package org.logan.test.kotlin.basic.cp08.ext8321

import org.logan.test.kotlin.basic.cp08.ext8311.Person
import org.logan.test.kotlin.basic.cp08.ext8311.people

/**
 * desc: 从 lambda 返回：使用标签返回，即：局部返回<br/>
 *
 *
 * time: 2020/1/6 4:10 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    lookForAlice(people)
    lookForAlice2(people)
}


fun lookForAlice(people: List<Person>) {
    /**
     * lambda中的局部返回跟 for循环中的 break表达式相似。它会终止 lambda的执行，并接着从调用 lambda的代码处执行。
     * 要区分局部返回和非局部返回，要用到标签。
     * 想从一个 lambda 表达式处返回你可以标记它，然后在 return 关键字后面引用这个标签，如下：
     **/
    // 给lambda表达式声明标签：label@
    people.forEach label@{
        if (it.name == "Alice") {
            println("Found!")
            return@label // return@label引用了这个标签
        }
    }

    println("Alice might be somewhere")
}


fun lookForAlice2(people: List<Person>) {
    // 用函数名作为 return 标签，如下的forEach。但是注意：如果你显式地指定了 lambda表达式的标签，
    // 再使用函数名作为标签没有任何效果。一个lambda表达式的标签数量不能多于一个。
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return@forEach // return@forEach从lambda表达式返回
        }
    }

    println("Alice might be somewhere")
}