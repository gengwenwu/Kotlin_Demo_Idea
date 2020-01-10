package org.logan.test.kotlin.basic.cp09

/**
 * desc: 泛型函数 <br/>
 *
 * time: 2020/1/7 11:14 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 声明一个范型扩展函数，下面 slice() 的类型形参为 T
// 声明类型形参：第一个<T>
// 接收者类型参数：第二个<T>
// 返回类型参数：第三个<T>
// fun <T> List<T>.slice(indices: IntRange): List<T>

fun main() {

    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2)) // 显示指定类型实参
    println(letters.slice(0..2)) // 编译集推倒出T为Char


    val authors = listOf("David", "Alice")
    val readers = mutableListOf("Andy", "Alice")
    println(authors.filter { it !in readers }) // filter 函数的声明,它接收一个函数类型 (T) -> Boolean 的参数。
}


