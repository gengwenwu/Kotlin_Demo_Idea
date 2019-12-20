package org.logan.test.kotlin.basic.cp08

/**
 * desc: 通过 lambda 去除重复代码 - 3 <br/>
 * time: 2019/12/20 11:53 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
    )

    val averageMobileDuration = log
        .filter { it.os in setOf(OS.IOS, OS.ANDROID) } // 过滤出 Android和IOS
        .map(SiteVisit::duration)
        .average()
    println(averageMobileDuration)

    // 如果 需要使用更加复杂的条件，如何处理？见 8.1.6_4_RemovingDuplicationThroughLambdas.kt
}