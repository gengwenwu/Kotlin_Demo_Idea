package org.logan.test.kotlin.basic.cp06

/**
 * desc: 可空类型 <br/>
 * 问号可以加在任何类型的后面，表示这个类型的变量可以存储 null 引用 : String?、 Int?、 MyCustomType? 等。
 * Type? = Type or null。 没有问号的类型表示这种类型的变量不能存储 null 引用。
 *
 * time: 2019-09-22 12:13 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 参数s是非空类型，不允许传递null，否则会编译不通过
fun strLen(s: String) = s.length

/**
 * String后面的?，表示参数s可以接受null类型。
 * 一旦与null进行比较操作后，编译器就会记住 ，并且在这次比较发生的作用域内把这个值当作"非空"来对待。
 **/
fun strLenSafe(s: String?) =
    if (s != null) s.length else 0

// String后面加?后，s.length是编译不通过的，因为可能为null。在语法上，Kotlin是禁止的。
// fun strLen(s: String?) = s.length


// val x: String? = null
// val y: String = x //编译错误，不能把可空类型赋值给非空类型的变量


fun main(args: Array<String>) {
    // 不能把可空类型的值传给拥有非空类型参数的函数
    // strLen(null) // 编译错误："Null can not be a value of a non-null type String"


    val x: String? = null
    println(strLenSafe(x))
    println(strLenSafe("abc"))
}