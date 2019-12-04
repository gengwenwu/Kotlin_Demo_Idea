package org.logan.test.kotlin.basic.cp06

/**
 * desc: Kotlin数组 - 基本数据类型 <br/>
 * 数组类型的类型参数始终会变成对象类型。如果要声明基本类型的数组，需要特殊类。
 * Kotlin提供了若干独立的类，每一种基本数据类型都对应一个，如下：
 * IntArray、LongArray、ByteArray、CharArray、BooleanArray 等给其他类型
 *
 * 要创建一个基本数据类型的数组，你有如下选择:
 * (1)，该类型的构造方法接收 size参数，并返回一个使用对应基本数据类型默认值 (通常是 0)初始化好的数组。
 * (2)，工厂函数(如：IntArray的intArrayOf()）接收变长参数的值并创建存储这些值的数组。
 * (3)，另一种构造方法，接收一个大小和一个用来初始化每个元素的 lambda。
 *
 * time: 2019/12/4 3:01 PM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {
    val fiveZeros = IntArray(5) // 创建存储了5个0的整型数组
    val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)


    // 接收 lambda 的构造方法的例子:
    val squares = IntArray(5) { i -> (i + 1) * (i + 1) }
    println(squares.joinToString())


    val numbers = arrayOf<Int>(1, 2, 3)
    numbers.toIntArray() // 转换成 基本数据类型数组
    fiveZeros.toTypedArray() // 转换 包装类型数组

}