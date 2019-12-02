package org.logan.test.kotlin.basic.cp10

/**
 * desc: Kotlin中使用@Deprecated注解 <br/>
 * 在Kotlin中的含义和Java一样，但是 Kotlin用 replaceWith 参数增强了它。<br/>
 * 可以提供一个替代者，以支持平滑地过渡到 API的新版本。<br/>
 *
 * time: 2019-09-07 13:58 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

@Deprecated("", ReplaceWith("removeAt(index)")) // ReplaceWith 指定替换的新函数
fun remove(index: Int) {

}

fun removeAt(index: Int) {

}

fun main(args: Array<String>) {
    // alt + enter 自动提示替换。
    remove(2)

}

