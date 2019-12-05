package org.logan.test.kotlin.basic.cp07

/**
 * desc: 运算符函数的返回类型 也可以不同于任一运算数类型 <br/>
 *
 * time: 2019/12/5 2:53 PM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

operator fun Char.times(count: Int): String {
    return toString().repeat(count) // Char运算符，但是返回String
}

fun main(args: Array<String>) {
    println('a' * 3) // 接收一个Char作为左值， Int作为右值，然后返回一个String 类型。
}
