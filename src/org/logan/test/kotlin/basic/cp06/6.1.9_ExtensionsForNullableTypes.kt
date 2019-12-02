package org.logan.test.kotlin.basic.cp06

/**
 * desc: 可空类性的扩展 <br/>
 * 为可空类型定义扩展函数是一种更强大的处理 null 值的方式。 <br/>
 * 它允许接收者为 null 的(扩展函数)调用，并在该函数中处理 null，而不是在确保变量不为 null 之后再调用它的方法。 <br/>
 * 只有扩展函数才能做到这一点，普通成员方法的调用是通过对象实例来分发的，因此实例为null 时(成员方法)永远不能被执行。 <br/>
 *
 * 譬如：Kotlin 标准库中定义的 String 的两个扩展函数 isEmpty 和 isBlank 就是这样的例子。
 *
 * time: 2019-09-28 13:14 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) { // 这里不需要安全调用 !! 或 ?.
        println("Please fill in the required fields.")
    }
}

fun main(args: Array<String>) {
    verifyUserInput(null) // 这里传入null，也不会导致有异常
    verifyUserInput(" ")
    testLetFunction()
}

fun String?.isNullOrBlack(): Boolean = // 可空字符串的扩展，在扩展函数语法基础上，再加一个?
    this == null || this.isBlank() // 第二个this使用了智能转换

/**
 * 当你为一个可空类型(以?结尾)定义扩展函数时，这意味着你可以对可空的值调用这个函数；
 * 并且函数体中的 this 可能为null，所以你必须显式地检查。
 * 在Java中，this 永远是非空的。Kotlin中，在可空类型的扩展函数中，this可以为null。
 **/


fun testLetFunction() {
    val person: Person? = null
    person.let {
        // 使用let，必须使用安全调用运算符?. ，否则传入非空函数中，会有运行时错误，如下：
       // sendEmailTo(it) // ERROR: Type mismatch: inferred type is Person? but Person was expected
    }
}

/**
 * 注意：
 * 自定义扩展函数时，需要考虑该扩展是否需要为可空类型定义。默认情况下，应该把它定义成非空类型的扩展函数。
 * 如果发现大部分情况下，需要在可空类型上使用这个函数，稍后再安全地修改它(不会破坏其他代码) 。
 * */