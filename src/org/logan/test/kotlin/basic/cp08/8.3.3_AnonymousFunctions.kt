package org.logan.test.kotlin.basic.cp08.ext833

import org.logan.test.kotlin.basic.cp08.ext8311.Person
import org.logan.test.kotlin.basic.cp08.ext8311.people

/**
 * desc: 匿名函数: 默认使用局部返回 <br/>
 *       匿名函数看起来跟普通函数很相似，除了它的名字和参数类型被省略了外。
 *
 *       匿名函数给 lambda表达式提供了另一种可选的语法，用不同的规则来解析 return 表达式。
 *       可以在需要编写有多个退出点的代码块的时候使用它们。
 *
 * time: 2020/1/6 4:38 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    lookForAlice(people)
    useAnonymousFunctionInFilter()
}

fun lookForAlice(people: List<Person>) {
    people.forEach(fun(person) { // 使用匿名函数取代lambda表达式
        if (person.name == "Alice") {
            println("Found!")
            return // return 指向最近的函数：一个匿名函数
        }
    })

    println("Alice might be somewhere")
}

// 在 filter 中使用匿名函数
fun useAnonymousFunctionInFilter() {
    // 匿名函数和普通函数有相同的指定返回值类型的规则。
    // 如下代码，代码块体医名函数需要显式地指定返回类型，如果使用表达式函数体，就可以省略返回类型。
    people.filter(fun(person): Boolean {
        return person.age < 30
    }).let {
        println(it)
    }


    // 在匿名函数中，不带标签的 return 表达式会从匿名函数返回 ，而不是从包含匿名函数的函数返回。
    // 这条规则很简单: return 从最近的使用 fun 关键字声明的函数返回。
    println(people.filter(fun(person) = person.age < 30))

    // return 返回比较：
    //    lambda表达式没有使用 fun 关键字，所以 lambda中的 return 从最外层的函数返回。
    //    匿名函数使用了fun， 所以， return 表达式从匿名函数返回，而不是从最外层的函数返回。


    // 注意
    // 尽管匿名函数看起来跟普通函数很相似，但它其实是 lambda 表达式的另一种语法形式而已。
    // 关于 lambda 表达式如何实现，以及在内联函数中如何被内联的讨论同样适用于匿名函数。

}


