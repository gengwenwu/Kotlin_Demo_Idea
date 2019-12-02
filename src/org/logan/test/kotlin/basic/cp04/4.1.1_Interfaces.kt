package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin接口 <br/>
 * 1，默认是public final。
 * 2，Kotlin的接口与Java8中的相似：它们都可以包含抽象方法的定义、非抽象方法的实现（Java8 default 方法），但它们不能包含任何状态。<br/>
 * 3，默认实现方法不需要加default关键字。 <br/>
 * 4，在接口中，不能使用final、open或者abstract。接口中的成员始终是open的。
 * 5，Kotlin 1.0是以Java6为目标设计的，并且不支持接口中的默认方法。 <br/>
 *    因此它会把每个带默认方法的接口编译成一个普通接口和一个将方法体作为静态函数的类(DefaultImpls)的结合体。<br/>
 * -
 * time: 2019-08-29 10:35 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

interface Clickable { // 使用 interface声明

    // 普通的方法声明
    fun click()

    // 带默认实现, 不用写上default
    fun showOff() = println("I was clicked!")

}


// 和Java一样，一个类可以实现任意多个接口，但只能继承一个类。
// Kotlin在类名后面使用冒号代替Java中的extends和implements。
class Button : Clickable {

    // 使用override 标注被重写的父类、接口的方法和属性，并且override是强制的
    override fun click() = println("I was clicked")

}

//====================两个接口，包含同样签名的函数，会发生什么？=======================

// 定义了与 Clickable 同样签名的函数 showOff()
interface Focusable {

    fun setFocus(b: Boolean) {
        println("I ${if (b) "got" else "lost"} focus.")
    }

    fun showOff() = println("I'm focusable!")

}


class Button2 : Clickable, Focusable {

    // 如果没有显示实现showOff()，将会编译错误。 如果同样的继承成员不止一个实现，必须提供一个显示实现。
    override fun showOff() {
        super<Clickable>.showOff() // Kotlin中 super加上泛型指定父类型表明调用哪父类方法
        super<Focusable>.showOff() // Java中，使用Focusable.super.showOff() 调用
    }

    override fun click() = println("Button 1 I was clicked")
}

