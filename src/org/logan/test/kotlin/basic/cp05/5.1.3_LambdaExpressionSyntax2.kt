package org.logan.test.kotlin.basic.cp05

/**
 * desc: Lambda表达式语法 - 逐步解剖Lambda <br/>
 * time: 2019-09-05 14:13 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    // 最精简写法 (求年龄最大值)
    people.maxBy { it.age }


    // 1，上面的例子，扩展开来的语法应该是下面这样
    people.maxBy({ p: Person -> p.age })

    /**
     * 2，Kotlin有这样一种语法约定，如果lambda表达式是函数调用的最后一个实参，它可以放在括号的外边。 <br/>
     *    如果你想传递两个或更多的lambda，不能把超过一个的lambda放在外面。 <br/>
     *    这时使用常规语法来传递它们通常是更好的选择(lambda都放在小括号里)，方便阅读。<br/>
     **/
    people.maxBy() { p: Person -> p.age }

    // 3，当lambda是函数唯一的实参时，还可以去掉调用代码中的空括号。
    people.maxBy { p: Person -> p.age } // 显示地写出参数类型

    /**
     *  4，推导出参数类型。如果lambda参数的类型可以被推导出来，就不需要显示地指定它。 <br/>
     *     一条简单的规则：先不声明类型，等编译器报错后再指定它们。<br/>
     *
     *     可以指定部分实参的类型，而剩下的实参只用名称。<br/>
     *     如果编译器不能推导出其中一种类型，又或是显示的类型可以提升可读性，这种做法或许更方便。<br/>
     **/
    people.maxBy { p -> p.age }

    /**
     *  5，如果当前上下文期望的是"只有一个参数的lambda"且这个参数的"类型可以推断"出来，就会生成it。<br/>
     *  注意：it约定能大大缩短代码，但不应该滥用它。尤其是在嵌套lambda的情况下，最好显示地声明每个lambda地参数。<br/>
     *  否则，很难搞清楚it引用的到底是哪个值。<br/>
     **/
    people.maxBy { it.age } // “it”是自动生成的参数名称


    // 用变量存储lambda，那么就没有可以推断出参数类型的上下文，所以必须显示地指定参数类型：
    val age = { p: Person -> p.age } // 必须显示地指定参数类型
    people.maxBy(age)


}