package org.logan.test.kotlin.basic.cp02

/**
 * desc: Kotlin新特性 - 字符串模版 <br/>
 * 可以在字符串中引用局部变量，只需要在这个变量名称前面加上美元符号<br/>
 * time: 2019-08-22 14:41 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main(args: Array<String>) {

    val name = if (args.size > 0) args[0] else "Kotlin"
    println("Hello, $name") // $name，就是字符串模板


    // 使用$字面值
    println("正常输出\${}")


    if (args.isNotEmpty()) {
        println("Hello, ${args[0]}!")  // 复杂$表达式，带有{}
    }

    // 复杂$表达式，强制带有{}，双引号中可以嵌套双引号
    println("Hello, ${if (args.size > 0) args[0] else "someone"}")

}