package org.logan.test.kotlin.basic.cp03

/**
 * desc: 最终版Collection.joinToString  <br/>
 * time: 2019-08-26 16:53 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = " ",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)

        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}


fun main(args: Array<String>) {
    val list = arrayListOf(1, 2, 3)
    println(list.joinToString("|"));

}

