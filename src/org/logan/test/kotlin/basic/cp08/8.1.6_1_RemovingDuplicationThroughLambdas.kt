package org.logan.test.kotlin.basic.cp08

/**
 * desc: 通过 lambda 去除重复代码 - 1 <br/>
 *       函数类型和 lambda 表达式一起组成了一个创建可重用代码的好工具。
 *
 * time: 2019/12/20 11:23 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
//
enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

//
data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

fun main() {
    val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
    )

    val averageWindowDuration = log
        .filter { it.os == OS.WINDOWS } // 过滤出windows机器
        .map(SiteVisit::duration)
        .average()
    println(averageWindowDuration)

    val averageWindowDuration2 = log
        .filter { it.os == OS.MAC } // 过滤出Mac机器
        .map(SiteVisit::duration)
        .average()
    println(averageWindowDuration2)

    // 过滤window、mac，又要写一份代码。优化见： 8.1.6_2_RemovingDuplicationThroughLambdas.kt
}
