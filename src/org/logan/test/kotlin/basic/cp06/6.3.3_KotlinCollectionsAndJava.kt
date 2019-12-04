package org.logan.test.kotlin.basic.cp06

import org.logan.test.kotlin.basic.cp06.java.CollectionUtils

/**
 * desc: Kotlin集合与Java集合相互操作 <br/>
 *
 * 每一个Kotlin接口都是其对应Java集合接口的一个实例(如：Iterable、Collection、List等)。
 * 在 Kotlin和 Java之间转移并不需要转换；不需要包装器也不需要拷贝数据。
 * 但是每一种 Java集合接口在 Kotlin 中都有两种表示: 一种是只读的，另一种是可变的。
 *
 * Kotlin集合接口都是在Kotlin中声明的。Kotlin中只读接口和可变接口的基本结构与 java.util 中的 Java集合接口的结构是平行的。
 * 可变接口直接对应java.util 包中的接口，而它们的只读版本缺少了所有产生改变的方法。
 *
 * Java 并不会区分只读集合与可变集合，即使 Kotlin 中把集合声明成只读的，Java代码也能够修改这个集合。
 * Kotlin 编译器不能完全地分析Java代码到底对集合做了什么。
 *
 * time: 2019/12/4 10:57 AM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun printlnUppercase(list: List<String>) {// 声明只读参数
    println(CollectionUtils.uppercaseAll(list)) // 调用可以修改集合的Java函数
    println(list.first())
}

fun main(args: Array<String>) {
    val list = listOf("Hello", "World")
    printlnUppercase(list)
}