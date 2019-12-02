package org.logan.test.kotlin.basic.cp06

/**
 * desc: Kotlin 基本数据类型 <br/>
 * Kotlin 并不区分基本数据类型和它们的包装类，基本数据类型和引用类型是一样的。
 *
 * 在运行时，数字类型会尽可能地使用最高效的方式来表示。
 * 大多数情况下，对于变量、属性、参数和返回类型 -- 如：Kotlin的 Int类型会被编译成 Java基本数据类型 int。
 * 唯一例外是泛型类，比如集合。用作泛型类型参数的基本数据类型会被编译成对应的Java包装类型。
 *
 * time: 2019-11-26 19:21 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100) //progress 是int，可以调用函数
    println("We are ${percent}% done!")
}


fun main(args: Array<String>) {
    showProgress(146)


    val i: Int = 1
    val list: List<Int> = listOf(1, 2, 3) // List的范型对应Java的Integer
}