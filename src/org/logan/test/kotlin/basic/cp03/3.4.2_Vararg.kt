package org.logan.test.kotlin.basic.cp03

/**
 * desc: Kotlin 可变参数声明 <br/>
 * 1，声明可变参数：vararg。 Java是3个点 ... <br/>
 * 2，传递数组参数变量语法，使用 展开运算符：* <br/>
 *    Kotlin要求显示地解包数组，以便每个数组元素在函数中能作为单独的参数调用。<br/>
 * 3，vararg声明的数组，是不允许传入 null，否则直接 crash。
 *
 * time: 2019-08-27 11:52 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main(args: Array<String>) {

    printlnNames("Logan", "Megan", "McRate", "Nice")

    val array = arrayOf("周杰伦", "张学友", "刘德华")
    printlnNames(*array) // 使用展开运算符* 传递参数
}


// 使用 vararg 声明可变参数
fun printlnNames(vararg names: String) {
    for (name in names) {
        println(name)
    }
}
