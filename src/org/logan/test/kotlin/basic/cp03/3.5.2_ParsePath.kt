package org.logan.test.kotlin.basic.cp03

/**
 * desc: Kotlin: 正则表达式和三重引号的字符串 <br/>
 * """ (三重引号的字符串)，不需要对任何字符串进行转义。正如写一个普通的字符串字面值一样。<br/>
 * 它的目的，不仅在与避免转义字符，而且它可以包含任何字符串，包括换行符。 <br/>
 *
 * time: 2019-08-27 14:30 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 使用String 扩展函数解析
fun parsePathByStringExt(path: String) {
    // String扩展函数 substringBeforeLast()、substringAfterLast()

    val dir = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfter(".")

    println("dir: $dir, fileName: $fileName, extension: $extension")
}

// 使用正则表达式 + 三重引号 解析
fun parsePathByRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex() // """三重引号
    val matchResult = regex.matchEntire(path)

    if (matchResult != null) {
        val (dir, fileName, extension) = matchResult.destructured
        println("dir: $dir, fileName: $fileName, extension: $extension")
    }
}

fun main(args: Array<String>) {
    val path = "/Users/logan/kotlin-book/chapter.doc"
    //
    parsePathByStringExt(path)
    //
    parsePathByRegex(path)


    val kotlinLogo = """| //
        .|//
        .|/ \"""
    println(kotlinLogo.trimMargin(".")) // 调用trimMargin()删除每行中的前缀和前缀的空格。
}
