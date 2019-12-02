package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin 访问修饰符 - public(默认)、protected、private、internal <br/>
 * 1，Kotlin没有"包私有"概念，使用internal，表示“只在模块内部可见”。它优势在于提供了对模块实现细节的真正封装。<br/>
 *    字节码中会变成public，应该避免在Java中意外使用internal类。<br/>
 * 2，Kotlin允许在顶层声明中使用private可见性，包括类、函数和属性。这些声明只会在声明它们的文件中可见。(类中 + 文件中)。<br/>
 * 4，protected修饰符在java和Kotlin中有不同的行为。Kotlin中，protected成员只在类和它的子类中可见。Java中，同一个包也是可见的。 <br/>
 * 5，Kotlin private类，它会被编译成包私有声明java代码，因为在Java中你不能把类声明为private。 <br/>
 * 6，通用的规则是：类的基础类型和类型参数列表中用到的所有类，或者函数的签名都有着与这个类或者函数本身相同的可见性。 <br/>
 * -
 * time: 2019-08-29 13:52 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
internal open class TalkativeButton : Focusable {

    private fun yell() = println("Hey!")

    protected fun whisper() = println("Let's talk")

}


/* 下面是编译错误代码

fun TalkativeButton.giveSpeech() { // 错误1：函数public成员暴露了其internal接受者类型TalkativeButton

    yell() // 错误2：不能访问TalkativeButton 私有函数

    whisper() // 错误3：不能访问TalkativeButton protected成员 (因为该函数只是扩展函数)
}

**/

// 解决错误1方案有两种。(1)，给函数添加 internal。(2)，将TalkativeButton internal 修改成 public
internal fun TalkativeButton.giveSpeech2() {


}

