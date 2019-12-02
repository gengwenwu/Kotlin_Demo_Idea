package org.logan.test.kotlin.basic.cp06

/**
 * desc: Unit类型: Kotlin 的“void” <br/>
 * Kotlin中的 Unit 类型完成了 Java 中的 void 一样的功能。大多数情况下，你不会留意到 void 和 Unit 之间的区别。

 * time: 2019-11-27 15:00 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 当函数没什么有意思的结果要返回时，它可以用作函数的返回类型:
fun f(): Unit {} // 显示声明Unit

fun f1() {} // 返回类型Unit被省略了


/*
*  Kotlin的 Unit 和 Java的void到底有什么不一样呢? Unit是一个完备的类型，可以作为类型参数，而void却不行。
*  只存在一个值是 Unit 类型，这个值也叫作Unit，并且(在函数中)会被隐式地返回。
*  当你在重写返回泛型参数的函数时这非常有用，只需要让方法返回 Unit 类型的值，如下例：
*/
interface Processor<T> {
    fun process(): T
}

class NoResultProcessor : Processor<Unit> {
    override fun process() { // 返回 Unit，但可以省略类型说明
        // 这里不需要显式的return，编译器会隐式地加上 return Unit
    }
}

// 和 Java对比一下， Java 中为了解决使用“没有值”作为类型参数的任何一种可能解法，都没有 Kotlin的解决方案这样漂亮。
// 一种选择是使用分开的接口定义来分别表示需要和不需要返回值的接口，如：Callable 和 Runnable
