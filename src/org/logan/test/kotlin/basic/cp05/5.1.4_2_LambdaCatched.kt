package org.logan.test.kotlin.basic.cp05


/**
 * desc: Kotlin - 被lambda捕获 <br/>
 * time: 2019-09-06 11:30 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Ref<T>(var value: T)


fun main(args: Array<String>) {
    /**
     * 案例一：
     * 捕获一个可修改的变量：实现细节 Java只允许你捕获不可修改的变量。当你想要捕获可修改变量时，
     * 可以使用以下技巧之一：声明一个存储可变值元素的数组，或者创建一个存储可改变引用的包装器类的实例。
     * 下面是Kotlin中的相似的代码：
     **/
    val counter = Ref(0) // 用来模拟捕捉一个可修改变量的类
    val inc = { ++counter.value }  // 形式上，一个不可变变量被捕获了。但是实际的值存储在一个字段中而且可以被修改
    println(inc.invoke())

    /**
     *  案例二：
     *  在Kotlin中，你不需要创建这样的包装器。相反的，你可以直接的修改变量。
     **/
    var counterInKotlin = 0
    val incInKotlin = { ++counterInKotlin }
    println(incInKotlin.invoke())

    // 案例一展示了案例二的底层工作原理。在任意时刻，你捕获了一个不可修改变量（val），它的值就被复制了，
    // 就像在Java中那样。当你捕获一个可修改变量（var）时，它的值被保存为一个 Ref 类的实例。
    // Ref 变量是不可被修改的。它很容易被捕获。然而真实值保存在一个字段中，并且可以通过lambda进行修改。
}

/**
 * 一个重要的告诫：如果lambda用作一个事件句柄，或者异步执行，本地变量(临时变量)的修改只会在lambda被执行的时候发生。
 * 下面的代码不是统计按钮点击次数的正确方式：这个函数总会返回0。
 * 正确的实现，需要保存点击次数到非本地变量，而是在一个依然可以在函数外部进行访问的位置。如：类的属性。
 **/
//fun tryToCountButtonClicks(button: Button): Int {
//    var clicks = 0
//    button.setOnClickListener { clicks++ }
//    return clicks
//}