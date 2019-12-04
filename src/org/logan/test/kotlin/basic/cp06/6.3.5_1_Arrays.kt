package org.logan.test.kotlin.basic.cp06

/**
 * desc: Kotlin数组 <br/>
 * Kotlin中的一个数组是一个带有类型参数的类，其元素类型由范型指定。<br/>
 *
 * 要在 Kotlin 中创建数组，有下面这些方法供你选择 :
 * (1)、arrayOf() 创建一个数组，它包含的元素是指定为该函数的实参。
 * (2)、arrayOfNulls() 创建一个给定大小的数组，包含的是 null元素。当然，它只能用来创建包含元素类型可空的数组。
 * (3)、Array构造方法：接收数组的大小和一个 lambda表达式，调用 lambda表达式来创建每一个数组元素。
 *     这就是使用非空元素类型来初始化数组，但不用显式地传递每个元素的方式。
 *
 * time: 2019/12/4 2:20 PM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    val numbers = arrayOf(1, 2, 3)
    for (i in numbers.indices) { // 扩展函数indices，下标
        println("number $i is : ${numbers[i]}") // 通过下标访问
    }


    val nullArray = arrayOfNulls<Int>(5) // 这里的Int对应java的Integer包装类
    for (item in nullArray) {
        println(item)
    }


    val letters = Array(26) { i -> ('a' + i).toString() }
    println(letters.joinToString(""))


    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray())) // 期望vararg参数时，使用展开运算符*传递数组

}