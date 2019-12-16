package org.logan.test.kotlin.basic.cp07.ext7522


/**
 * desc: 使用委托属性: 惰性初始化和 “by lazy()” <br/>
 *       可以与7.5.2_1_LazyEmails.kt代码对比。
 *
 * time: 2019/12/16 2:41 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Email { /*...*/ }

fun loadEmails(person: Person): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(/*...*/)
}

class Person(val name: String) {
    // 使用委托属性会让代码变得简单得多，可以封装用于存储值的支持属性和确保该值只被初始化一次的逻辑。
    // lazy 函数返回一个对象，该对象具有一个名为 getValue 且签名正确的方法，因此可以把它与 by 关键字一起使用来创建一个委托属性。
    // lazy 的参数是一个 lambda，可以调用它来初始化这个值。默认情况下，lazy函数是线程安全的，
    // 如果需要，可以设置其他选项来告诉它要使用哪个锁，或者完全避开同步，如果该类永远不会在多线程环境中使用。
    val emails by lazy { loadEmails(this) }

}