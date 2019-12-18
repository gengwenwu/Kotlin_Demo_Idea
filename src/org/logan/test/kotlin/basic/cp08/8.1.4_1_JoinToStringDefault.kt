package org.logan.test.kotlin.basic.cp08

/**
 * desc: 函数类型的参数默认值 <br/>
 *       声明函数类型的参数的时候可以指定参数的默认值。
 *       声明函数类型的默认值并不需要特殊的语法，只需要把lambda作为值放在=号后面。
 *
 * time: 2019/12/18 6:40 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 未使用函数类型例子
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        result.append(element) // 使用默认的toString() 方法将对象转换为字符串。待优化！
    }

    result.append(postfix)
    return result.toString()
}

// 使用函数类型优化后
fun <T> Collection<T>.joinToString2(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() } // 优化1，声明一个以lambda为默认值的函数类型的参数。
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        result.append(transform(element)) // 优化2，调用作为实参传递给transform形参的函数
    }

    result.append(postfix)
    return result.toString()
}


fun main() {
    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString2()) // 全部使用默认值
    println(letters.joinToString2 { it.toLowerCase() }) // 传入lambda
    println(
        letters.joinToString2(
            separator = "! ",
            postfix = "!",
            transform = { it.toUpperCase() }) // 使用命名参数语法传参
    )

}