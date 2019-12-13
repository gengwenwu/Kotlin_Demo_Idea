package org.logan.test.kotlin.basic.cp07

import java.time.LocalDate

/**
 * desc: in运算符的约定：调用 iterator() <br/>
 * 第二章，在 Kotlin中，for循环中也可以使用in运算符，和做区间检查一样。但是在这里情况下它的含义是不同的: 它被用来执行迭代。
 * 这意味着一个诸如 for(x in list) {...} 将被转换成 list.iterator ()的调用，
 * 然后就像在 Java 中一样，在它上面重复调用 hasNext 和 next 方法 。
 *
 * time: 2019/12/12 6:42 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main() {
    // 请注意，在 Kotlin 中，in这也是一种约定，这意味着 iterator()可以被定义为扩展函数。
    // 这就解释了为什么可以遍历一个常规的 Java字符串: 标准库已经为 CharSequence 定义了一个扩展函数 iterator，而它是String 的父类：
    for (c in "abc") {
        println(c)
    }


    val newYear = LocalDate.ofYearDay(2017, 1)
    val daysOff = newYear.minusDays(1)..newYear
    for (dayOff in daysOff) { // 对应iterator函数实现后，遍历daysOff
        println(dayOff)
    }
}

// 请注意如何在自定义区间类型上定义 iterator方法:
// 使用 LocalDate 作为类型参数。如上一节所示，rangeTo() 返回一个 ClosedRange 的实例，
// 并且 ClosedRange<LocalDate> 的 iterator 扩展允许在 for 循环中使用区间的实例。
operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {// 这个对象实现了遍历LocalDate元素的Iterator
        var current = start

        override fun hasNext() =
            current <= endInclusive // <=使用了compareTo预定

        override fun next() =
            current.apply { current = plusDays(1) } // 把当前日期添加一天
    }