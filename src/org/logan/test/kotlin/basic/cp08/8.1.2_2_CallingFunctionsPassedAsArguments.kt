package org.logan.test.kotlin.basic.cp08

/**
 * desc: 调用作为参数的函数 - 实现一个简单版本的filter函数 <br/>
 *
 * time: 2019/12/18 4:14 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun String.filter(predicate: (Char) -> Boolean): String {// 这里的(Char) -> Boolean是函数类型参数
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)

        if (predicate(element)) { // 调用作为参数传递给predicate的函数
            sb.append(element)
        }
    }

    return sb.toString()
}


fun main() {
    println("ab1c".filter { it in 'a'..'z' })
}