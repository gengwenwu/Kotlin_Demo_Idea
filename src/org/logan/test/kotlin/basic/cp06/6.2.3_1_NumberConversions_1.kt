package org.logan.test.kotlin.basic.cp06

/**
 * desc: 数字转换 - 显示转换(赋值、比较的时候) <br/>
 * Kotlin 和 Java之间一条重要的区别就是处理数字转换的方式。
 * Kotlin 不会自动地把数字从一种类型转换成另外一种，即便是转换成范围更大的类型。
 *
 * time: 2019-11-27 13:45 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {
    // 每一种基本数据类型(Boolean 除外)都定义有转换函数: toByte()、toShort() 、toChar()等。 这些函数支持双向转换：
    // 既可以把小范围的类型括展到大范围，比如Int.toLong()，也可以把大范围的类型截取到小范围，比如Long.toInt() 。
    val i = 1
    // val l: Long = i // 编译错误！Type mismatch: inferred type is Int but Long was expected
    val l: Long = i.toLong() // 必须显式地进行转换


    // Kotlin 要求转换必须是显式的，只有类型相同的值才能比较，尤其是在比较装箱值的时候。
    // 比较两个装箱值的equals方法不仅会检查它们存储的值，还要比较装箱类型。
    // 如果在代码中同时用到了不同的数字类型，你就必须显式地转换这些变量，来避免意想不到的行为。
    val x = 1
    val list = listOf(1L, 2L, 3L)
    // x in list // 编译错误， Type inference failed. The value of the type parameter T should be mentioned in input types (argument types, receiver type or expected type). Try to specify it explicitly.
    println(x.toLong() in list) // OK，返回true


}