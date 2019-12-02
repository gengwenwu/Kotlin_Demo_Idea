package org.logan.test.kotlin.basic.cp06

/**
 * desc: 数字转换 - 字符串转换 <br/>
 * Kotlin 标准库提供了一套相似的扩展方法，用来把字符串转换成基本数据类型( toint、 toByte、 toBoolean 等)

 * time: 2019-11-27 14:18 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main(args: Array<String>) {
    // 每个这样的函数都会尝试把字符串的内容解析成对应的类型，如果解析失败则抛出 NumberFormatException。
    println("42".toLong())
    println(Any().javaClass)
}