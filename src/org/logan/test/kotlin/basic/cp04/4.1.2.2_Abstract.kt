package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin抽象类 <br/>
 * time: 2019-08-29 13:37 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
abstract class Animated {// 同Java一样，使用abstract声明。这个类是抽象的：不能创建它的实例。


    abstract fun animate() // 抽象成员始终是open的


    open fun stopAnimating() { // 抽象类中的非抽象并非默认open的，但可以标注为open。

    }

    fun animateTwice() { // 依旧final

    }

}