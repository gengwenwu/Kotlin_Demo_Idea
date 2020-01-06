package org.logan.test.kotlin.basic.cp08.ext8311

/**
 * desc: lambda 中的return语句：从一个封闭的函数返回，这样的 return语句叫作"非局部返回" <br/>
 *
 * 需要注意的是，只有在以 lambda 作为参数的函数是内联函数的时候才能从更外层的函数返回。
 * 在一个非内联函数的 lambda 中使用 return 表达式是不允许的。
 *
 * time: 2020/1/6 3:47 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

data class Person(val name: String, val age: Int)

val people = listOf(Person("Alice", 29), Person("Bob", 31))

fun main() {
    lookForAlice(people)
    lookForAliceUseForEach(people)
}

// 普通遍历使用return
fun lookForAlice(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            return // 找到Alice，推出函数执行
        }
    }

    println("Alice is not found") // 没有找到Alice，打印这一行
}

// 在传递给 forEach 的 lambda 中使用 return，实现效果和上面的lookForAlice()实现效果一样
fun lookForAliceUseForEach(people: List<Person>) {

    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            // 如果你在 lambda 中使用 return 关键字，它会从调用 lambda 的函数中返回，并不只是从 lambda 中返回。
            // 这样的 return语句叫作非局部返回，因为它从一个比包含 return 的代码块更大的代码块中返回了。
            // 当使用以 lambda 作为参数的函数的时候 Kotlin 保留了同样的行为。
            return

            // 需要注意的是，只有在以 lambda 作为参数的函数是内联函数的时候才能从更外层的函数返回。在上面的代码中，
            // forEach的函数体和lambda的函数体一起被内联了，所以在编译的时候能很容易做到从包含它的函数中返回。
            // 在一个非内联函数的 lambda 中使用 return 表达式是不允许的。一个非内联函数可以把传给它的 lambda 保存在变量中，
            // 以便在函数返回以后可以继续使用，这个时候 lambda 想要去影响函数的返回己经太晚了。
        }
    }

    println("Alice is not found") // 没有找到Alice，打印这一行
}

