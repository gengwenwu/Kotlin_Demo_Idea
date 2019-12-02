package org.logan.test.kotlin.basic.cp03

/**
 * desc: 给Kotlin函数参数设置默认值，解决因参数过多而导致的函数重载过多问题。<br/>
 * 注意：参数的默认值是被编码到声明函数的地方，而不是调用的地方。<br/>
 * 如果你改变了参数的默认值并重新编译这个函数，没有给参数重新赋值的调用者，将会使用新的默认值。<br/>
 * time: 2019-08-25 20:23 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main(args: Array<String>) {
    val list = listOf(1, 7, 53)

    // 当使用常规的调用语法时，必须按照函数声明中定义的参数顺序来给定参数，可以省略掉的只有排在末尾的参数。
    // 如果使用命名参数，可以省略中间一些参数，也可以按照任意顺序放置参数。
    println(joinToString2(list))

    println(joinToString2(list, "? "))

    println(joinToString2(list, "? ", "<", ">"))

}


// Java没有参数默认值的概念，当你从Java中调用Kotlin函数的时候，必须显示地指定所有的参数值。
// 如果需要从Java代码中作频繁的调用，而且希望它对Java的调用者更简便，可以使用@JvmOverloads注解它。
// 这个指示编译器生成Java重载函数，从最后一个开始省略每个参数。
@JvmOverloads
fun <T> joinToString2(
    collection: Collection<T>,
    separator: String = ", ", // 给参数设置默认值
    prefix: String = "{",
    postfix: String = "}"
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) {
            result.append(separator)
        }

        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

