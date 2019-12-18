package org.logan.test.kotlin.basic.cp08

/**
 * desc: 高阶函数 - 函数类型 <br/>
 *
 * 高阶函数：
 *   以另一个函数作为参数或者返回值的函数。在Kotlin中，函数可以用lambda或者函数引用(::)来表示。
 *   因此，任何以lambda或者函数引用作为参数的函数，或者返回值为 lambda 或函数引用的函数，或者两者都满足的函数都是高阶函数。
 *
 *
 * time: 2019/12/18 10:46 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 1，为了声明一个以 lambda作为实参的函数，你需要知道如何声明对应形参的类型。
//   把lambda表达式保存在局部变量中：
//      val sum = { x: Int, y: Int -> x + y }
//      val action = { println(42) }


// 2，上例中，编译器推导出 sum 和 action 这两个变量的函数类型。这些变量的显式类型声明是什么样的：
//      val sum: (Int, Int) -> Int = { x, y -> x + y }  // 有两个Int型参数和Int型返回值的函数
//      val action: () -> Unit = { println(42) } // 没有参数和返回值的函数，其中Unit是不可以省略的(如果显示写出来的话)


// 3，Kotlin中的函数类型语法:
//   (Int, String) -> Unit  // 将函数参数类型放在括号中，紧接着是一个箭头和函数的返回类型。左边是入参，右边是返回值。
//                             函数类型声明总是需要一个显式的返回类型，在这种场景下 Unit 是不能省略的。


// 4，可空类型
//      // 函数类型的 返回值 也可以标记为可空类型：
//      var canReturnNull: (Int, Int) -> Int? = { x, y -> null }

//      // 也可以定义一个函数类型的可空变量。为了明确表示是变量本身可空，而不是函数类型的返回类型可空，
//      // 你需要将整个函数类型的定义包含在括号内，并在括号后面添加一个问号 (与上面例子区别：关键是在小括号):
//      var funOrNull: ((Int, Int) -> Int)? = null


// 5，函数类型的参数名
//    可以为函数类型声明中的参数指定名字
fun performRequest(
    url: String,
    callback: (code: Int, content: String) -> Unit // 函数类型的参数现在有了名字code, content
) {

}

fun main() {
    val url = "http://kotl.in"
    val code = 200

    performRequest(url) { code, content -> /***/ } // 可以直接使用lambda定义的名称
    performRequest(url) { code, page -> /***/ } // 也可以修改名称，如：page，并不会影响内部调用

}