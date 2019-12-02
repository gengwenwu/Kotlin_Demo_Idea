package org.logan.test.kotlin.basic.cp05

/**
 * desc: SAM构造方法：显式地把 lambda 转换成 函数式接口(SAM) <br/>
 * SAM构造方法是编译器生成的函数，让你执行从 lambda 到函数式接口实例的显式转换。可以在编译器不会自动应用转换的上下文中使用它。<br/>
 * 例如，如果有一个方法返回的是一个函数式接口的实例，不能直接返回一个lambda，要用 SAM构造方法把它包装起来。<br/>
 *
 * 尽管方法调用中的 SAM 转换一般都自动发生，但是当把lambda作为参数传给一个重载方法时，<br/>
 * 也有编译器不能选择正确的重载的情况。这时，使用显式的 SAM构造方法 是解决编译器错误的好方法。 <br/>
 *
 * time: 2019-09-19 15:26 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}

fun main(args: Array<String>) {
    // SAM构造方法的名称和底层函数式接口的名称一样。
    // SAM构造方法只接收一个参数 -> 一个被用作函数式接口单抽象方法体的lambda -> 并返回实现了这个接口的类的一个实例。
    createAllDoneRunnable().run()


    /* SAM 构造方法还可以用在需要把从 lambda生成的函数式接口实例 存储在一个变量中的情况 */
//    val listener = View.OnClickListener {}
//    val button1: Button? = null
//    val button2: Button? = null
//
//    button1?.setOnClickListener(listener)
//    button2?.setOnClickListener(listener)


    // Lambda 和添加/移除监昕器
    // ======
    // 注意 lambda 内部没有匿名对象那样的this: 没有办法引用到 lambda 转换成的匿名类实例。
    // 从编译器的角度来看，lambda 是一个代码块，不是一个对象，而且也不能把它当成对象引用。 Lambda 中的 this引用指向的是包围它的类。
    // 如果你的事件监听器在处理事件时还需要取消它自己，不能使用 lambda 这样做。这种情况使用实现了接口的匿名对象。
    // 在匿名对象内，this关键字指向该对象实例，可以把它传给移除监听器的API。

}