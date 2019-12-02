package org.logan.test.kotlin.basic.cp05

/**
 * desc: Kotlin 序列 asSequence()，类似于Java8流的翻版。<br/>
 * Kotlin惰性集合操作的入口就是Sequence接口。这个接口表示的就是一个可以逐个列举元素的元素序列。<br/>
 * Sequence只提供了一个方法，iterator()，用来从序列中获取值。 <br/>
 *
 * Sequence接口的强大之处在于其操作的实现方式。序列中的元素求值是惰性的。 <br/>
 * 因此，可以使用序列更高效地对集合元素执行链式操作，而不需要创建额外的集合来保存过程中产生的中间结果。 <br/>
 * 可以调用扩展函数 asSequence() 把任意集合转换成序列，调用 toList() 来做反向的转换。 <br/>
 * 通常，需要对一个大型集合执行链式操作时要使用序列。<br/>
 *
 * time: 2019-09-18 16:35 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 27), Person("Bob", 31))

    println("没有使用序列的执行顺序：")
    println(people
        .map {
            // map操作符，它会创建一个列表
            println("map() -> ${it.name}")
            it.name
        }
        .filter {
            // filter操作符 会创建一个列表
            println("filter() -> ${it}")
            it.startsWith("A")
        })


    println("")
    println("使用序列之后的执行顺序 (看输出的log，比较执行顺序)：")
    println(people.asSequence() // 通过asSequence()把集合转换成序列
        .map {
            println("map() -> ${it.name}")
            it.name
        }.filter {
            println("filter() -> ${it}")
            it.startsWith("A")
        }.toList() // 把结果转换成列表
    )

}