package org.logan.test.kotlin.basic.cp06

/**
 * desc: Kotlin Nothing类型：“这个函数永不返回” <br/>
 * Nothing 类型没有任何值，只有被当作函数返回值使用，或者被当作泛型函数返回值的类型参数使用才会有意义。
 * 在其他所有情况下，声明 一个不能存储任何值 的变量没有任何意义。
 *
 * time: 2019-11-27 15:25 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 对某些 Kotlin 函数来说，"返回类型”的概念没有任何意义，因为它们从来不会成功地结束。
// 如下例，它通过抛出带有特定消息的异常来让当前测试失败。一个包含无限循环的函数也永远不会成功地结束。
// 当分析调用这样函数的代码时，知道函数永远不会正常终止是很有帮助的。 Kotlin 使用一种特殊的返回类型 Nothing来表示。
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

fun main(args: Array<String>) {
    // fail("Error occurred.")


    // 返回 Nothing 的函数可以放在 Elvis 运算符的右边来做先决条件检查。在类型系统中拥有 Nothing 为什么极其有用。
    // 编译器知道这种返回类型的函数从不正常终止，然后在分析调用这个函数的代码时利用这个信息。
    // val address = Company("Google", null).address ?: fail("No address!")
    // println(address.city)
}