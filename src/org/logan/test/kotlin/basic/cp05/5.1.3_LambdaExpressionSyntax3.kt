package org.logan.test.kotlin.basic.cp05

/**
 * desc: Lambda表达式语法 - lambda命名参数传递 <br/>
 * time: 2019-09-05 14:42 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    // 把lambda作为命名实参传递
    people.joinToString(separator = " ", transform = { p: Person -> p.name })

    /**
     * 把lambda放在括号外传递
     * 代码变的更加简洁了，但是没有显示地表明lambda应用到哪里，所以不熟悉被调用的函数的那些人可能更难理解。
     **/
    people.joinToString(" ") { p: Person -> p.name }

}