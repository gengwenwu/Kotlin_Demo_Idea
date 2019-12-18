@file:JvmName("ProcessTheAnswer")

package org.logan.test.kotlin.basic.cp08

/**
 * desc: 在 Java 中使用函数类 <br/>
 *
 * 其背后的原理是，函数类型被声明为普通的接口: 一个函数类型的变量是 FunctionN 接口的一个实现。
 * Kotlin 标准库定义了一系列的接口，这些接口对应于不同参数数量的函数: FunctionO<R> (没有参数的函数)、
 * Function1<P1, R> (一个参数的函数)，等等。每个接口定义了一个 invoke()，调用这个方法就会执行函数。
 *
 * 一个函数类型的变量就是实现了对应的 FunctionN 接口的实现类的实例，实现类的 invoke 方法包含了lambda函数体。
 * 譬如：val action = { println(42) }，action是实现了Function0接口的实例。
 *
 * 在 Java 中可以很简单地调用使用了函数类型的 Kotlin 函数, Java8的lambda会被自动转换为函数类型的值。
 *
 * time: 2019/12/18 4:33 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}


fun main() {
    // 对比ProcessTheAnswerAnonymous.java例子来看。
    val list = mutableListOf<String>()
    list.add("42")

    list.forEach {
        println(it)
    }
}