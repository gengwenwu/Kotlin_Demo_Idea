package org.logan.test.kotlin.basic.cp05

/**
 * desc: Lambda表达式基本语法 <br/>
 * {x: Int, y: Int -> x + y} <br/>
 *
 * Kotlin的lambda表达式始终用花括号{}包围，箭头把实参列表和lambda的函数体隔开。<br/>
 * 箭头左边是入参(注意，没有小括号包起来)，箭头后边是具体的实现。<br/>
 *
 * time: 2019-09-05 13:57 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    // 可以把lambda表达式存储在一个变量中，把这个变量当作普通函数对待。
    val sum = { x: Int, y: Int -> x + y }
    println(sum(1, 2));


    // 可以直接调用lambda表达式, 但是这样的语法毫无可读性。它等价于执行lambda函数体中的代码。
    { println(42) }()


    // 把一小段代码封装在一个代码块中，可以使用库函数run来执行传给它的lambda。替代上面的写法。
    run { println(42) }


}

