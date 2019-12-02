package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin 类 <br/>
 * 1，Class类默认是 public final 的。类默认是final带来了一个重要的好处就是这使得在大量场景中的智能转换成为可能。<br/>
 * 2，类中的函数默认是public final；添加open后转换成可重写 (转换非final的)。 <br/>
 * 3，实现、重写 父类函数，Kotlin强制使用override关键字。并自动转换open的。 <br/>
 * -
 * open、final和abstract修饰符：默认为final
 * time: 2019-08-29 11:24 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
open class RichButton : Clickable {

    // 属性默认 private
    var text1: String? = null;
    val text2: String? = null;

    // 类函数默认 public final，不能在子类中重写
    fun disable() {}

    // open表示可以在子类中重写它
    open fun animate() {}

    // 重写了一个open的函数，它本身同样就是open的。添加final关键字，变成非open的。
    final override fun click() {}

}
