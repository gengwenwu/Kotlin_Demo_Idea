package org.logan.test.kotlin.basic.cp05

/**
 * desc: SAM接口 (函数式接口) <br/>
 * 接口只有一个抽象方法。这种接口被称为：函数式接口，或 SAM接口，它代表单个抽象方法。如：Java的Runnable、Callable 接口。<br/>
 * Kotlin 允许你在调用接收SAM接口作为参数的方法时使用lambda，来保证你的 Kotlin代码既整洁又符合习惯。<br/>
 *
 * 注意：和 Java不同，Kotlin拥有完全的"函数类型"。 <br/>
 * 正因为这样，需要接收 lambda作为参数的Kotlin函数，应该使用函数类型而不是 SAM类型，作为这些参数的类型。<br/>
 * Kotlin 不支持把 lambda自动转换成实现 Kotlin 接口的对象。
 *
 * time: 2019-09-19 11:06 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main(args: Array<String>) {

    Thread {
        println("执行Runnable的run()函数")
    }.start()
}