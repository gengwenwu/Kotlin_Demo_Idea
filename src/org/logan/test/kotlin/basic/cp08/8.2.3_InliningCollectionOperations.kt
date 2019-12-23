package org.logan.test.kotlin.basic.cp08.ext823

/**
 * desc: 内联集合操作 <br/>
 * time: 2019/12/20 3:56 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Bob", 31))

fun main() {
    // 手动过滤一个集合
    val result = mutableListOf<Person>()
    for (people in people) {
        if (people.age < 30)
            result.add(people)
    }
    println(result)


    // Kotlin，filter、map函数被声明为内联函数，上面实现所产生的字节码和下面实现所产生的字节码大致是一样的。
    // 你可以很安全地使用符合语言习惯的集合操作， Kotlin对内联函数的支持让你不必担心性能的问题。
    println(people.filter { it.age > 30 }.map { Person::name })

    // 但上面面这段代码，多创建了一个中间集合，用来保存列表过滤的结果，由filter函数生成的代码会向这个集合中添加元素，
    // 而由 map 函数生成的代码会读取这个集合。如果有大量元素需要处理，中间集合的运行开销将成为不可忽视的问题，
    // 这时可以在调用链后加上一个 asSequence 调用，用序列来替代集合。
}