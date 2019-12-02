package org.logan.test.kotlin.basic.cp04

/**
 * desc: 声明一个带默认构造方法或属性的类 <br/>
 * 1，主构造函数：在大多数真实的场景中，类的构造方法是非常简单的：它要么没有参数或者直接把参数与对应的属性关联。<br/>
 *    这就是为什么Kotlin有为主构造方法设计的简洁的语法。 <br/>
 * 2，constructor 关键字，可声明 主构造和从构造。<br/>
 * 3，init关键字，初始化操作，会和主构造方法一起使用。 <br/>
 *
 * time: 2019-08-30 11:43 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

/**
 * 主构造方法 （声明参数 + 属性初始化）<br/>
 * val意味着相应的属性会用构造方法的参数来初始化。<br/>
 **/
class User(val nickname: String)

// 解析上面User类代码 (全量版本)
class User2 constructor(_nickname: String) { // constructor关键字用来开始一个主构造方法或从构造方法的声明。

    val nickname: String


    // init关键字用来引入一个 初始化语句块。
    // 这种语句块包含了在类被创建时执行的代码，并会和主构造方法一起使用。
    // 因为主构造方法有语句限制，不能包含初始化代码，这就是为什么要使用初始化语句块的原因。
    // 可以有多个初始化语句块
    init {
        this.nickname = _nickname
    }

}

// 精简User类代码 (版本1)
class User3(_nickname: String) {
    val nickname = _nickname
}

// 精简User类代码 (最终版版本)
class User4(val nickname: String) // val意味着相应的属性会用构造方法的参数来初始化


// ======= 上面所有的User，都是等价的。


/**
 * 构造方法可以设置默认值  <br/>
 * 如果所有的构造方法参数都有默认值，编译器会生成一个额外的不带参数的构造方法来使用所有的默认值。<br/>
 * */
class User5(val nickname: String, val isSubscribed: Boolean = true)


fun main(args: Array<String>) {
    val alice = User5("Alice")
    println(alice.isSubscribed)

    val bob = User5("Bob", false)
    println(bob.isSubscribed)


    val carol = User5("Carol", isSubscribed = false)
    println(carol.isSubscribed)

}