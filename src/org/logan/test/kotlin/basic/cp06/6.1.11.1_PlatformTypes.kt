package org.logan.test.kotlin.basic.cp06

import org.logan.test.kotlin.java.Person

/**
 * desc: 平台类型: 本质上就是 Kotlin不知道可空性信息的类型。Java类型在Kotlin中表示为平台类型。<br/>
 * 既可以把它当作可空类型处理，也可以当作非空类型处理。要像在Java中一样，对这个类型上做的操作负有全部责任。
 * 编译器将会允许所有的操作，它不会把对这些值的空安全操作高亮成多余的。
 * 在使用 Java API 时要特别小心这种问题。
 *
 * time: 2019-11-26 15:08 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun yellAt(person: Person) { // 这里的Person是平台类型
    println(person.name.toString() + "!!") // person.name可能为null
}

fun yellAtSafe(person: Person) {
    println((person.name ?: "Anyone").toString() + "!!")
}

// 声明平台类型
fun declarePlatform(person: Person) {
    // 在Kotlin 中不能声明一个平台类型的变量，这些类型只能来自Java代码。但你可能会在 IDE 的错误消息中见到它们:
    // val i: Int = person.name // 编译错误，Type mismatch: inferred type is String! but Int was expected

    // String! 表示法被Kotlin编译器用来表示来自 Java代码的平台类型。 你不能在自己的代码中使用这种语法。
    // 而且感叹号通常与问题的来源无关，所以通常可以忽略它。它只是强调类型的可空性是未知的。


    // 下面两种声明都是有效的，java的属性可以被当作为空或者非空
    val s: String? = person.name
    val s1: String = person.name  // 这种声明是OK的。如果你试图用来自Java的null值给一个非空的Kotlin变量赋值，
                                  // 在赋值的瞬间你就会得到异常。

}


fun main(args: Array<String>) {
    yellAtSafe(Person(null))
    //  yellAt(Person(null)) // NullPointerException
}