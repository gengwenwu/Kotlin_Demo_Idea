package org.logan.test.kotlin.basic.cp07

/**
 * desc: 解构声明和组件函数 <br/>
 * 一个解构声明看起来像一个普通的变量声明，但它在括号中有多个变量。事实上，解构声明再次用到了约定的原理。
 * 要在解构声明中初始化每个变量，将调用componentN() ，其中 N 是声明中变量的位置。
 * val (a, b) = p 实际执行如下：
 *      val a = p.component1()
 *      val b = p.component2()
 *
 * time: 2019/12/13 11:28 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    val p = Point(10, 20)
    val (x, y) = p // 声明变量x、y，然后用p的组件来初始化
    println("x=${x}, y=${y}")


    // 对于数据类（如：上面的Point），编译器为每个在 主构造方法 中声明的属性生成一个componentN()，
    // 下面的例子显示了如何手动为 非数据类 声明这些功能:
    // class Point(val x: Int, val y: Int) {
    //      operator fun component1() = x
    //      operator fun component2() = y
    // }

}