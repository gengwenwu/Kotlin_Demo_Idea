package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin object关键字用法3 - 对象表达式，改变写法的匿名内部类 <br/>
 * 1，object关键字不仅可以声明单例对象，还能用来声明匿名对象(对象表达式)，匿名对象替代了Java中匿名内部类的用法。<br/>
 * 2，Java匿名内部类只能扩展一个类或实现一个接口，Kotlin的匿名对象可以实现多个接口或者不实现接口。<br/>
 *
 * time: 2019-09-03 14:57 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

interface MouseAdapter {

    fun mouseClicked()

    fun mouseEntered()
}

fun addMouseListener(adapter: MouseAdapter) {

}


fun showAnonymousClassByObject() {

    var clickCount = 0

    /**
     * 对象表达式声明了一个类并创建了该类的一个实例，但是并没有给这个类或者实例分配一个名字。<br/>
     * 与对象声明不同，匿名对象不是单例的。每次对象表达式被执行都会创建一个新的对象实例。<br/>
     **/
    addMouseListener(object : MouseAdapter {
        override fun mouseEntered() {
            clickCount++ // 更新变量的值。与Java不同，访问并没有被限制在final变量，还可以在对象表达式中修改变量的值
        }

        override fun mouseClicked() {

        }
    })

}