package org.logan.test.kotlin.basic.cp07

import java.time.LocalDate

/**
 * desc: ..运算符的约定：rangeTo() <br/>
 * 要创建一个区间，请使用 ..语法。举个例子，1..10 代表所有从 1到 10的数字。..运算符是调用 rangeTo()的一个简洁方法。
 *
 * start..end --> start.rangTo(end) // ..运算符将被转换为 rangeTo() 的调用。
 *
 * rangeTo()返回一个区间。你可以为自己的类定义这个运算符。但是，如果该类实现了 Comparable 接口，那么不需要这么做了：
 * 你可以通过 Kotlin 标准库创建一个任意可比较元素的区间，这个库定义了可以用于任何可比较元素的 rangeTo():
 * operator fun <T: Comparable<T>> T.rangeTo(that: T): ClosedRange<T> // 这个函数返回一个区间，可以用来检测其他一些元素是否属于它。
 *
 * time: 2019/12/12 5:35 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    val now = LocalDate.now()
    // 创建一个从今天开始的10天的区间
    // now .. now.plusDays(10) 表达式将会被编译器转换为 now.rangeTo (now.plusDays(lO))。
    val vacation = now..now.plusDays(10)
    println(now.plusWeeks(1) in vacation) // 检查一个特定的日期是否属于这个区间


    val n = 9
    println(0..(n + 1)) // ..运算符的优先级低于算术运算符，最好把参数括起来以免混淆.


    (0..n).forEach { println(it) } // 把区间括起来，来调用它的方法


}