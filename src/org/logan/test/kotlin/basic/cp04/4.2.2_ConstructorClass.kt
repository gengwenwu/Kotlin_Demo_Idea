package org.logan.test.kotlin.basic.cp04



/**
 * desc: Kotlin从构造函数 <br/>
 * 1，Java的互操作性是你需要使用从构造方法的主要场景。<br/>
 * 2，如果类没有主构造方法，那么每个从构造方法必须初始化基类或者委托给另一个这样做了的构造方法。<br/>
 * -
 * time: 2019-09-01 16:10 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

/*

open class View2 { // 这个类没有主构造方法（因为类名后面并没有括号），

    // 使用constructor声明从构造函数，可以声明任意多个从构造方法。
    constructor(ctx: Context)

    constructor(ctx: Context, attr: AttributeSet?)

}


// 继承View2，使用super实现基类构造方法
class MyButton2 : View2 {

    constructor(ctx: Context) : super(ctx) // 使用super调用父类构造方法

    constructor(ctx: Context, attr: AttributeSet) : super(ctx, attr)

}


// 继承View2，使用this()
class MyButton3 : View2 {

    // 使用this()，委托给其它构造实现基类的构造方法
    constructor(ctx: Context) : this(ctx, null)

    constructor(ctx: Context, attr: AttributeSet?) : super(ctx, attr)
}
*/
