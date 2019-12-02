package org.logan.test.kotlin.basic.cp05

/**
 * desc: Kotlin apply 函数几乎和 with 函数一模一样， <br/>
 * 最大的区别是：它始终会返回作为实参传递给它的对象(即：接收者对象)  <br/>
 *
 * apply被声明成一个扩展函数，它的接收者变成了作为实参的lambda的接收者。（with是顶层函数)
 *
 * time: 2019-09-22 11:32 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun alphabet5() = StringBuilder()
    .apply {
        for (letter in 'A'..'Z') {
            append(letter)
        }
        append("\nNow I know the alphabet")
    }

/**
 * 许多情况下 apply 都很有效，其中一种是在创建一个对象实例并需要用正确的方式初始化它的一些属性的时候。 <br/>

fun createViewWithCustomAttributes(context: Context) {
    TextView(context).apply {
        text = "Sample Text"
        textSize = 20.0f
        setPadding(10, 0, 0, 0)
        // 新的 TextView 实例创建之后立即被传给了 apply。
    }
}
 **/
/**
 * with 函数和 apply 函数是最基本和最通用的使用带接收者的 lambda 的例子。
 * 更多具体的函数也可以使用这种模式，可以使用标准库函数 buildString 进一步简化 alphabet 函数。
 * 它也是带有接收者的lambda。
 **/
fun alphabet6() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
}
