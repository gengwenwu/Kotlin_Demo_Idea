package org.logan.test.kotlin.org.docs.functions

import org.logan.test.kotlin.basic.cp02.Person


/**
 * desc: Scope Functions - 作用域函数 <br/>
 *       Kotlin提供了5个作用域函数，let、run、with、apply、also，它们的唯一目的是在对象的上下文中执行代码块。 <br/>
 *       当对一个对象调用这样的函数并提供一个 lambda 表达式时，它会形成一个临时作用域。  <br/>
 *       在此作用域中，可以访问该对象而无需其名称，可以使你的代码更加简洁易读。<br/>
 *
 *       由于作用域函数的相似性质，为你的案例选择正确的函数可能有点棘手。选择主要取决于你的意图和项目中使用的一致性。<br/>
 *       每个作用域函数之间有两个主要区别：
 *          (1)、引用上下文对象的方式 (this 或 it)。<br/>
 *          (2)、返回值 (入参对象 或 其它自定义数据值)。<br/>
 *
 *       1，上下文对象：this 还是 it
 *          (1), 作为 lambda 表达式的接收者（this）
 *              run、with 以及 apply 通过关键字 this 引用上下文对象(可以省略this)。
 *              对于主要对对象成员进行操作（调用其函数或赋值其属性）的 lambda 表达式，建议将上下文对象作为接收者（this）。
 *
 *          (2)，作为 lambda 表达式的参数（it）
 *              let、also 将上下文对象作为 lambda 表达式参数。it 比 this 简短，因此，当上下文对象在作用域中主要
 *              用作函数调用中的参数时，使用 it 作为上下文对象会更好。若在代码块中使用多个变量，则 it 也更好。
 *
 *       2，返回值：根据返回结果，作用域函数可以分为以下两类：
 *          (1)，apply、also 返回上下文对象。
 *          (2)，let、run、with 返回 lambda 表达式结果。
 *
 *
 *       记忆口诀：
 *          let、also 使用it，其它是this；
 *          apply、also 返回上下文对象，其它是最后一句。
 *
 *       参考地址：https://www.kotlincn.net/docs/reference/scope-functions.html#run
 *
 * time: 2020/5/19 3:40 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    showLetFunctionUseCase()
}

fun showLetFunctionUseCase() {
    // 1, let 用于在调用链的结果上调用一个或多个函数
    val numbers = listOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }
        .let {
            println(it)
            // 如果需要可以调用更多it对象的函数
        }

    // 2，let 经常配合操作符 ?. 使用
    val str: String? = "hello"
    val length = str?.let {
        println("let() called on $it")
        it.length  // 编译通过：'it' 在 '?.let { }' 中必不为空
    }

    // 3, let 引入 作用域受限的局部变量 以提高代码的可读性，如下面的firstItem
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!" + firstItem + "!"
    }.toUpperCase()
    println("First item after modifications: '$modifiedFirstItem'")

}

/**
 *  建议使用 with 来调用上下文对象上的函数，而不使用 lambda 表达式结果。
 *  with 可以理解为“对于这个对象，执行以下操作。
 **/
fun showWithFunctionUseCase() {
    val numbers = mutableListOf("one", "two", "three")

    // 1, 针对对象的属性或函数处理
    with(numbers) {
        println("'with' is called with argument $this")
        println("It contains $size elements")
        println("first element is ${this.first()}")
    }

    // 2, 使用对象的属性或函数将用于计算一个值，如：firstAndLast
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," + " the last element is ${last()}"
    }

    println(firstAndLast)
}


fun showRunFunctionUseCase() {
    // run 和 with 做同样的事情，但是调用方式和 let一样(扩展函数)

    // 当 lambda 表达式同时包含对象初始化和返回值的计算时，run 很有用。
    val person = Person("Logan", true)
    val runResult = person.run {
        isMarried = false
        "runResult "
    }
    println(runResult)

    // 同样的代码如果用 let() 函数来写:
    val letResult = person.let {
        it.isMarried = false
        "letResult"
    }
    println(letResult)

}
