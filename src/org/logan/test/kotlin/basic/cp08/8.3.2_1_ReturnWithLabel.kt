package org.logan.test.kotlin.basic.cp08.ext8321

import org.logan.test.kotlin.basic.cp08.ext8311.Person
import org.logan.test.kotlin.basic.cp08.ext8311.people

/**
 * desc: 从 lambda 返回：使用标签返回，即：局部返回 <br/>
 *
 *       局部返回的语法相当冗长，如果一个 lambda 包含多个返回语句会变得更加笨重。
 *       解决方案是，可以使用另一种可选的语法来传递代码块: 匿名函数。见 8.3.3_AnonymousFunctions.kt。
 *
 * time: 2020/1/6 4:10 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    lookForAlice(people)
    lookForAlice2(people)
    thisUseLabel()
}


fun lookForAlice(people: List<Person>) {
    /**
     * lambda中的局部返回跟 for 循环中的 break 表达式相似。它会终止 lambda的执行，并接着从调用 lambda的代码处执行。
     * 要区分局部返回和非局部返回，就要用到标签。
     * 想从一个 lambda 表达式处返回你可以标记它，然后在 return关键字后面引用这个标签，如下：
     **/
    // 给lambda表达式声明标签：label@
    people.forEach label@{
        if (it.name == "Alice") {
            println("Found!")
            return@label // return@label 引用了这个标签，返回到调用lambda的代码处
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

// 上面的规则，同样也可应用于 this 表达式的标签。
fun thisUseLabel() {
    // 下面的 apply 表达式的隐式接收者StringBuilder 可以通过 this@sb 访问
    println(StringBuilder().apply sb@{
        listOf(1, 2, 3).apply {
            // this指向作为域内最近的隐式接收者。
            // 所有隐式接收者都可以被访问，外层的接收者通过显式的标签访问
            // 和 return表达式中使用标签一样，可以显式地指定lambda表达式的标签，也可以使用函数名作为标签。
            this@sb.append(this.toString())
        }
    })

}