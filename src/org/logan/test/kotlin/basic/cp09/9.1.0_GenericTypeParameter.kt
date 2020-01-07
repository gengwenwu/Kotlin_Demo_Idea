package org.logan.test.kotlin.basic.cp09

/**
 *  desc: 泛型类型参数 <br/>
 *
 *  可以给类或接口的方法、顶层函数，以及扩展函数、扩展属性声明类型参数。
 *
 *  在 Java 中，可以声明 List 类型的变量，而不需要说明它可以包含哪种类型。
 *  但是，Kotlin 始终要求类型实参要么被显式地说明，要么能被编译器推导出来，不能随意省略。
 *
 * time: 2020/1/7 11:32 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main() {

    // Kotlin编译器能够根据参数值推导出类型实参
    val authors = listOf("David", "Alice") // 两个值都是字符串，编译器推导出正在创建一个List<String>


    // 创建一个空的列表，这样就没有任何可以推导出类型实参的线索，就必须要显式地指定类型形参
    val reader1: MutableList<String> = mutableListOf()
    // 也可以在创建列表的函数中指定类型实参
    val reader2 = mutableListOf<String>()
}