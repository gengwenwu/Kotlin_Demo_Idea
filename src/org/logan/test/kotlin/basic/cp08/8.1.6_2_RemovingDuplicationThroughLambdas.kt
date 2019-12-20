package org.logan.test.kotlin.basic.cp08

/**
 * desc: 通过 lambda 去除重复代码 - 2 <br/>
 * time: 2019/12/20 11:44 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun List<SiteVisit>.averageDurationFor(os: OS) = // 将重复代码抽取出来
    filter { it.os == os }.map(SiteVisit::duration).average()

fun main() {
    val log = listOf(
        SiteVisit("/", 34.0, OS.WINDOWS),
        SiteVisit("/", 22.0, OS.MAC),
        SiteVisit("/login", 12.0, OS.WINDOWS),
        SiteVisit("/signup", 8.0, OS.IOS),
        SiteVisit("/", 16.3, OS.ANDROID)
    )

    println(log.averageDurationFor(OS.MAC))
    println(log.averageDurationFor(OS.WINDOWS))

    // 如果你对来自移动平台(iOS 和 Android)的访问的平均时间非常有兴趣。那该怎么办？
    // 见 8.1.6_3_RemovingDuplicationThroughLambdas.kt 优化方案。
}