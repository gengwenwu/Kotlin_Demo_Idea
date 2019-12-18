package org.logan.test.kotlin.basic.cp08

/**
 * desc: 调用作为参数的函数 <br/>
 *
 * time: 2019/12/18 4:07 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3) // 调用函数类型参数，和调用普通函数的语法是一样的。
    println("The result is $result")
}

fun main() {
    twoAndThree { a, b -> a + b }

    twoAndThree { x, y -> x * y }
}