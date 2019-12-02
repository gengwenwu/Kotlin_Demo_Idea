package org.logan.test.kotlin.basic.cp06

import org.logan.test.kotlin.basic.cp05.sendEmail

/**
 * desc: Kotlin - Let函数 <br/>
 *  let 函数做的事情就是把一个调用它的对象变成lambda表达式的参数。 <br/>
 *  再结合安全调用语法，它能有效地把调用 let 函数的可空对象，转变成非空类型。 <br/>
 *
 *  foo?.let {
 *      ...it ...
 *  }
 *
 *  如果foo!=null，执行lambda表达式。foo==null，什么都不会发生。
 *
 * time: 2019-09-26 19:20 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}


fun main(args: Array<String>) {
    var email: String? = "it is a email."

    // 写法1
    // sendEmailTo(email) //编译不通过，Type mismatch: inferred type is String? but String was expected


    // 写法2
    if (email != null) { // 必须显式地检查这个值不为 null
        sendEmailTo(email)
    }


    // 写法3，使用let，最基本的写法
    email?.let { email -> sendEmailTo(email) }
    // 写法4，使用let，使用自动生成的名字 it 的简明语法
    email?.let { sendEmailTo(it) }


    // 案例4，null
    email = null
    email?.let { sendEmailTo(it) }

    /**
     * 案例5， let 函数也能被可空的接收者调用，但它并不检查值是否为null。
     * 如果你在一个可空类型直接上调用 let 函数，而没有使用安全调用运算符，lambda 的实参将会是可空的。
     * 因此，如果想要使用 let 来检查非空的实参，你就必须使用安全调用运算符?.
     **/
    val person: Person? = null
    person.let {
        // sendEmailTo(it) // 编译报错，sendEmailTo()参数email非空。ERROR: Type mismatch: inferred type is Person? but Person was expected
    }

}

