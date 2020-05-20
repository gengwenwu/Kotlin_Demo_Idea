package org.logan.test.kotlin.org.docs.functions

import org.logan.test.kotlin.basic.cp02.Person


/**
 * desc: Scope Functions - 作用域函数 <br/>
 *
 *       作用域函数唯一目的是：在对象的上下文中执行代码块。
 *
 *       Kotlin提供了5个作用域函数，let、run、with、apply、also。 <br/>
 *
 *       当对一个对象调用这样的函数并提供一个 lambda 表达式时，它会形成一个临时作用域。  <br/>
 *       在此作用域中，可以访问该对象而无需其名称(this、it)，可以使你的代码更加简洁易读。<br/>
 *
 *       由于作用域函数的相似性质，选择合适的函数可能有点棘手。选择主要取决于你的意图和项目中使用的一致性。<br/>
 *       每个作用域函数之间有2个主要区别：
 *          (1)、引用上下文对象的方式 (this 或 it)。<br/>
 *          (2)、返回值 (上下文对象 或 其它数据类型值)。<br/>
 *
 *       1，上下文对象：this 或 it
 *          (1), 作为 lambda 表达式的接收者（this）
 *              run、with 以及 apply 通过关键字 this 引用上下文对象 (可省略this)。
 *              对于主要对象成员进行操作（调用其函数 或 赋值其属性）的 lambda 表达式，建议选择这些函数。
 *
 *          (2)，作为 lambda 表达式的参数（it）
 *              let、also 将上下文对象作为 lambda 表达式参数(it)。it 比 this 简短，因此，当上下文对象在作用域中
 *              主要用作函数调用中的参数时，使用 it 作为上下文对象会更好。若在代码块中使用多个变量，则 it 也更好。
 *
 *       2，返回值：根据返回结果，可以分为以下两类：
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
    showWithFunctionUseCase()
    showRunFunctionUseCase()
    showApplyFunctionUseCase()
    showAlsoFunctionUseCase()
}


/**
 *  1, let() 使用案例：
 **/
fun showLetFunctionUseCase() {
    // 1, let 用于在调用链的结果上调用一个或多个函数
    val numbers = listOf("one", "two", "three", "four", "five")
    numbers.map { it.length }.filter { it > 3 }
        .let {
            println(it)
            // 如果需要可以调用更多it对象的函数
        }

    // 2，let 经常配合 操作符?. 使用
    val str: String? = "hello"
    val length = str?.let {
        println("let() called on $it")
        it.length  // 编译通过：'it' 在 '?.let { }' 中必不为空
    }

    // 3, let 引入 作用域受限的局部变量 以提高代码的可读性，如下面的 firstItem
    val modifiedFirstItem = numbers.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!" + firstItem + "!"
    }.toUpperCase()
    println("First item after modifications: '$modifiedFirstItem'")

}

/**
 *  2, with() 使用案例：
 *      建议使用 with 调用上下文对象上的函数，而不使用 lambda 表达式(it的方式)。
 *      with 可以理解为：“对于这个对象，执行某些操作，特别是多个操作。
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

/**
 *  3, run() 使用案例：
 *      1，当作扩展函数使用：run 和 with 做同样的事情，但是调用方式和 let一样，扩展函数。
 *      2，当作非扩展函数使用。
 **/
fun showRunFunctionUseCase() {
    //   1，在对象上调用run(扩展函数)，当run函数体同时包含：对象初始化 和 返回值的计算 时，run 很有用。
    val person = Person("Logan", true)
    val runResult = person.run {
        isMarried = false
        "runResult "
    }

    // 同样的代码如果用 let() 函数来写:
    val letResult = person.let {
        it.isMarried = false // 多了it
        "letResult"
    }


    // 2，将 run 用作非扩展函数，此时可以在需要表达式的地方执行一个由多个语句组成的块，如下面：hexNumberRegex
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"

        Regex("[$sign]?[$digits$hexDigits]")
    }

    for (match in hexNumberRegex.findAll("+1234 -FFFF not-a-number")) {
        println(match.value)
    }
}


/**
 * 4, apply() 使用案例：
 *
 *      apply同with一样：“对于这个对象，执行某些操作"，特别是多个操作。
 *      与with区别就是返回值， apply返回上下文对象本身。
 *
 *      apply 的常见情况是对象配置。
 **/
fun showApplyFunctionUseCase() {
    val logan = Person("Logan", false)
        .apply {
            isMarried = true
        }
}

/**
 * 5, also() 使用案例：
 *     also 可以将其理解为“并且用该对象执行以下操作”。
 *
 **/
fun showAlsoFunctionUseCase() {
    val numbers = mutableListOf("one", "two", "three")
    numbers.also { println("The list elements before adding new one: $it") }
        .add("four")
}

/**
 *
 *  官方给出选择作用域函数的简短指南：
 *
 *  1, 对一个非空（non-null）对象执行 lambda 表达式：let
 *  2, 将表达式作为变量引入为局部作用域中：let
 *  3, 对象配置：apply
 *  4, 对象配置并且计算结果：run
 *  5, 在需要表达式的地方运行语句：非扩展的 run
 *  6, 附加效果：also
 *  7, 一个对象的一组函数调用：with
 *
 *  不同函数的使用场景存在重叠，你可以根据项目或团队中使用的特定约定选择函数。
 *
 *
 *  我个人习惯方式：
 *      let 对空处理 ?.let
 *      with、apply 对对象内部操作，根据返回值选择 with 或 apply
 *      also 和官方一致。
 *
 **/