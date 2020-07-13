package org.logan.test.kotlin.basic.cp05

/**
 * desc: Kotlin - 在作用域内访问变量 <br/>
 * Kotlin 允许你在内部类或者Lambda中访问外部的变量，并可以修改它。(Java中只允许访问final变量) <br/>
 *
 * time: 2019-09-06 10:48 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// lambda表达式中访问外部成员变量
fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    // foreach 接受一个指定每个元素做什么的lambda作为参数，这里是String
    messages.forEach {
        println("$prefix $it") // 在lambda中访问"prefix"参数
    }
}


fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++ // lambda中修改外部变量
        } else if (it.startsWith("5")) {
            serverErrors++ // lambda中修改外部变量
        }
    }


    println("$clientErrors client errors, $serverErrors server errors.")
}

fun main(args: Array<String>) {

    // lambda中访问外部变量
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Errors:")

    // lambda中修改外部变量
    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal server Error")
    printProblemCounts(responses)


//    上面两个案例中的 prefix、clientErrors、serverErrors，可以说"被lambda捕获"了。
//    注意，本地变量的生命周期默认是限制在声明这个变量的函数内部的。但是如果它被lambda捕获了，使用这个变量的代码可以被存储起来并在后期执行。
//    这是怎么做到的？当你捕获到一个不可修改的变量时，它的值跟用到这个值的lambda代码一同保存。
//    对于不可更改的变量来说，（它的）值依附在一个特殊的"包装器内"。这个包装器允许你修改它。包装器的引用跟lambda同时存储。

}