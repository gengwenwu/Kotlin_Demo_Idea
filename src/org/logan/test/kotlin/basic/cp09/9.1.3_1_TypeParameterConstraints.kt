package org.logan.test.kotlin.basic.cp09

/**
 * desc: 类型参数约束 <br/>
 *       类型参数约束可以限制作为 (泛型)类 和 (泛型)函数 的类型实参的类型。
 *
 * 如果把一个类型指定为泛型类型形参的 上界约束，在泛型类型具体的初始化中，其对应的类型实参就必须是这个具体类型或者它的子类型。
 * 语法类似如下：
 *
 *      fun <T : Number> List<T>.sum(): T { ... } // Number是T数据类型的上界，Java用 extends 来表达同样的概念。
 *      println(listOf(1, 2, 3).sum()) // 1、2、3，Int类型继承了Number类。
 *
 * time: 2020/1/7 1:46 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 一旦指定了类型形参 T 的上界，就可以把类型 T 的值当作它的上界(类型)
fun <T : Number> oneHalf(value: T): Double {
    return value.toDouble() / 2.0
}

fun <T : Comparable<T>> max(first: T, second: T): T { // Comparable<T>表明，实参类型必须是可比较的元素
    // first > second 的简写形式会根据 Kotlin 的运算符约定被编译成 first.compareTo(second) > 0，
    // 这种比较之所以可行，是因为 first 的类型 T 继承自 Comparable<T>
    return if (first > second) first else second
}

// 可以在一个类型参数上指定多个约束，这时候需要使用不同的语法支持。
// 使用 where 关键字，指定 T 必须实现 CharSequence 和 Appendable 两个接口，譬如：StringBuilder类。
fun <T> ensureTrailingPeriod(seq: T) where T : CharSequence, T : Appendable {
    if (!seq.endsWith(".")) {
        seq.append(".")
    }
}

fun main() {
    // oneHalf()测试
    val intValue = 3 // int类型
    println(oneHalf(intValue))

    val numberValue: Number = 2 // number类型
    println(oneHalf(numberValue))

    val doubleValue = 3.4 // double类型
    println(oneHalf(doubleValue))


    // max() 测试
    println(max("Kotlin", "java")) // 字符串按字母表顺序比较
//  println(max("Kotlin", 42)) // 42编译错误，因为T的上界是Comparable<T>，String继承了Comparable<String>


    println(ensureTrailingPeriod(StringBuilder("Hello World")))
    // println(ensureTrailingPeriod("Hello World")) // 编译不通过，因为String只实现了CharSequence
}