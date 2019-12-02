package org.logan.test.kotlin.basic.cp10

/**
 * desc: Kotlin提供了各种注解来控制Kotlin编写的声明如何编译成字节码并暴露给 Java调用者。 <br/>
 * 1, 一些注解代替了 Java语言中关键字，如: @Volatile、@Strictfp 充当了 Java的 volatile、Strictfp的替身。 <br/>
 * 2, 其它的注解则是被用来改变 Kotlin声明对 Java调用者的可见性: @JvmName、@JvmStatic、@JvmOverloads、@JvmField等 <br/>
 *
 * time: 2019-09-07 16:09 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

@Volatile
private var running = false


class TestClass {

    @JvmField // 暴露成一个没有访问器的公有Java字段。
    var name: String? = null


    @JvmOverloads // 带默认参数值的函数生成多个重载函数
    fun showMsg(name: String, age: Int = 10, sex: String = "男") {

    }

    companion object {
        @JvmStatic // 暴露成 Java 的静态方法。 Java: TestClass.showDialog();
        fun showDialog() {

        }
    }

}