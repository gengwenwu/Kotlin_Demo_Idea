package org.logan.test.kotlin.basic.cp02

/**
 * desc: Kotlin 循环 <br/>
 * 1，while循环和Java完全一样。<br/>
 * 2，for循环仅以唯一一种形式存在：for <item> in <elements>。<br/>
 * time: 2019-08-23 11:05 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    UseIn()
    useDownTo()
    useUntil()

}

// Kotlin "for"循环
fun UseIn() {
    // 在Kotlin中没有for循环。为了替代这种循环用法，Kotlin提出了区间的概念。
    // 区间本质上就是两个值之间的间隔，这两个值通常是数字：一个起始值，一个结束值。
    // 注意: Kotlin的区间是包含的或者闭合的，意味着第二个值始终是区间的一部分。

    val oneToTen = 1..10 // 1..10表示区间。 ..语法始终创建的是包含结束值，即：包含10
    for (number in oneToTen) {
        println("number: ${number}")
    }


    for (i in 1..10) {
        println(".. ->" + fizzBuzz(i))
    }

}


// Kotlin until 语法
fun useUntil() {
    // until不包括结束值，如下：包含1，不包含10。
    for (i in 0 until 10) {
        println("until ->: ${i}")
    }
}


// Kotlin downTo 语法
fun useDownTo() {
    // 带步长的数列(下面的1)，它允许跳过一些数字。步长也可以是负数，这种情况下数列是递减而不是递增。
    // step把步长的绝对值变成2，但是必须保持方向一致。
    for (i in 20 downTo 1 step 2) {
        println("downTo ->: ${i}")
    }
}


fun fizzBuzz(i: Int) =
    when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Fizz"
        i % 5 == 0 -> "Buzz"
        else -> "$i"
    }



