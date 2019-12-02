package org.logan.test.kotlin.basic.cp03

/**
 * desc: 以命名参数名称方式调用Kotlin函数 <br/>
 * time: 2019-08-25 20:23 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    val list = listOf(1, 2, 3)

    // java 方式调用
    println(joinToString(list, ";", "(", ")"))

    // Kotlin命名参数方式调用
    // 如果在调用一个函数时，指明了一个参数名称，那它之后的所有参数都需要标明名称。
    // 当你在Java中调用该函数时(joinToString)，依旧不能采用命名参数方式
    println(joinToString(list, prefix = "(", postfix = ")", separator = ";"))


}


fun <T> joinToString( // 范型
    collection: Collection<T>,
    separator: String,
    prefix: String,
    postfix: String
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

