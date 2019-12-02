package org.logan.test.kotlin.basic.cp02

/**
 * desc: Kotlin 变量 <br/>
 * 1，val(来自value) - 不可变引用。它对应的是Java final变量，优先使用val。
 * 2，var(来自variable) - 可变引用。这种变量的值可以被改变，它对应的是普通java变量。
 * time: 2019-08-22 14:22 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main(args: Array<String>) {

    // Kotlin中声明变量：以关键字开始(val、var)，然后是变量名。
    var question = "how old you?"
    // var answer: Int = 18 // 显示声明数据类型
    val answer2 = 18 // 类型推到

    // 如果变量没有初始化器，必须显示地指定它的类型
    val answer3: Int
    answer3 = 18

    // 编译器只会根据初始化器来推断变量的类型，在确定类型的时候不会考虑后续的赋值操作
    val answer4 = 42
    // answer4 = "NO! " // 编译不通过


    /**
     * 在定义了val变量的代码块执行期间，val变量只能进行唯一一次初始化。<br/>
     * 但是，如果编译器能确保只有唯一一条初始化语句会被执行，可以根据条件使用不同的值来初始化它。<br/>
     */
    val message: String
    if (canPerformOperation()) {
        message = "Success" //唯一一次被初始化
    } else {
        message = "Failed" //唯一一次被初始化
    }


    // 注意，尽管val引用自身是不可变的，但是它执行的对象内容可能是可变的
    val languages = arrayListOf("Java")
    languages.add("Kotlin") //改变引用指向的对象

}


fun canPerformOperation() = true
