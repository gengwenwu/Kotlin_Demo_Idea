package org.logan.test.kotlin.basic.cp08.ext8164

import org.logan.test.kotlin.basic.cp08.OS
import org.logan.test.kotlin.basic.cp08.SiteVisit

/**
 * desc: 通过 lambda 去除重复代码 - 3 <br/>
 * time: 2019/12/20 1:45 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 用一个高阶函数去除重复代码
fun List<SiteVisit>.averageDurationFor(predicate: (SiteVisit) -> Boolean) =
    filter(predicate).map(SiteVisit::duration).average()

fun main() {
    val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
    )

    println(log.averageDurationFor { it.os == OS.IOS && it.path == "/signup" })

    // 注意：函数类型和lambda表达式进行简化，比如策略模式。
}