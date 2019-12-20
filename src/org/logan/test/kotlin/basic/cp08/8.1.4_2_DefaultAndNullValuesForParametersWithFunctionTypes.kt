package org.logan.test.kotlin.basic.cp08.ext8142

/**
 * desc: 函数类型的参数 null值 - 声明一个参数为可空的函数类型。<br/>
 *
 *      这种情况不能直接调用作为参数传递进来的函数：
 *          Kotlin会因为检测到潜在的空指针异常而导致编译失败。一种可选的办法是显式地检查null。
 *
 * time: 2019/12/18 6:59 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun <T> Collection<T>.joinToString2(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = { it.toString() } // 1，声明一个函数类型可空的
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        val str = transform?.invoke(element) // 2，使用安全调用语法调用函数 invoke()
            ?: element.toString() // 使用 elvis 运算符
        result.append(str) //
    }

    result.append(postfix)
    return result.toString()
}
