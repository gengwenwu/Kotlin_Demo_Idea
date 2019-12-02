package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin object关键字用法2 - 伴生对象 companion object。它是一个声明在类中的普通对象。 <br/>
 * 类的伴生对象会被编译成常规对象：容器类中的一个引用了它的实例的静态字段(如果未指定名称的话，这个字段名称是Companion)。 <br/>
 *
 * 1, 可以获得直接通过容器类名称来访问这个对象的方法和属性的能力，不再显示地指明对象的名称。（默认类名是Companion）<br/>
 * 2, 伴生对象可以访问类中的所有private成员，包括private构造方法，它是实现工厂模式的理想选择。 <br/>
 * 3，注意：伴生对象成员在子类中不能被重写。<br/>
 *
 * time: 2019-09-03 11:50 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class A {

    // companion object，声明 伴生对象。
    companion object {

        fun bar() {
            println("Companion object called")
        }
    }
}


class User8 private constructor(val nickname: String) { // 将主构造方法标记为私有

    companion object {
        // 伴生对象中定义函数
        fun newFacebookUser(account: Int) = User8("fb${account}")

        // 工厂方法 - 伴生对象访问私有构造
        fun newSubscribingUser(email: String) = User8(email.substringBefore('@'))

    }
}


fun main(args: Array<String>) {

    // 通过类名访问伴生对象
    A.bar()


    // 通过类名来调用companion object的方法：
    val subscribingUser = User8.newSubscribingUser("bob@gmail.com")
    val faceBookUser = User8.newFacebookUser(4)

    println(subscribingUser.nickname)
    println(faceBookUser.nickname)

}