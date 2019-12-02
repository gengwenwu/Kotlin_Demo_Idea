package org.logan.test.kotlin.basic.cp04

import java.io.Serializable

/**
 * desc: Kotlin 内部类 和 嵌套类 <br/>
 * 1，嵌套类：Kotlin中，没有任何显示修饰符的嵌套类是与Java中的static嵌套类性质一样的。<br/>
 * 2，内部类：Kotlin中，使用inner关键字声明的内部类与Java无任何声明的内部类性质一致。 <br/>
 * -
 * time: 2019-08-29 15:09 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

interface State : Serializable

interface View {

    fun getCurrentState(): State

    fun restoreState(statue: State)

}

// Kotlin 的静态嵌套类，无需显示声明static
class ButtonStatic() : View {

    override fun getCurrentState(): State = ButtonStatue()

    override fun restoreState(statue: State) {}

    // 下面的ButtonStatue 相当于Java的的static嵌套类。Java中需要使用static关键字
    class ButtonStatue : State {}

}

// Kotlin 内部类
class ButtonInner() : View {

    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(statue: State) {}

    // 下面的ButtonStatue 相当于Java的的内部类，使用inner关键字。Java中，不需要任何关键字。
    inner class ButtonState : State {}

}