package org.logan.test.kotlin.basic.cp02

/**
 * desc: 使用in检查集合和区间的成员 <br/>
 * time: 2019-08-25 15:43 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 使用 in 检查值是否在一个区间
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

// 逆运算!in
fun isNotDigit(c: Char) = c !in '0'..'9'

// in运算符和!in，也适用于when表达式
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit"
    in 'a'..'z' -> "It's a letter"
    else -> "I don't know.."
}

fun main(args: Array<String>) {

    println("q is Letter？${isLetter('q')}")
    println("x is not digit? ${isNotDigit('x')}")

    // 区间也不仅限于字符串。只要实现了java.lang.Comparable接口，就能创建这种类型的对象区间。
    // 如果是这样的区间，并不能列举出这个区间中的所有对象。
    println("Kotlin" in "Java".."Scala")


    // in也可以检查集合
    println("Kotlin" in setOf("Java", "Scala"))
}
