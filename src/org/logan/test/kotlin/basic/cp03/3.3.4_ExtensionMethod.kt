package org.logan.test.kotlin.basic.cp03

/**
 * desc: 不可重写的扩展函数 <br/>
 * 注意：如果一个类的成员函数和扩展函数有相同的签名，成员函数会优先被调用。 <br/>
 * 我们应该牢记，当扩展 API 类的时候：如果添加一个和扩展函数同名的成员函数， <br/>
 * 那么对应类重新编译代码后，这将会改变它的意义并开始指向新的成员函数，而不是扩展函数。 <br/>
 * -
 * time: 2019-08-26 17:12 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

open class View {
    // 普通函数
    open fun click() = println("View Click")
}

open class Button : View() {
    // 重写普通函数
    override fun click() = println("Button Click")
}


// 扩展函数
fun View.showOff() = println("I'm a View!")

fun Button.showOff() = println("I'm a Button!")


fun main(args: Array<String>) {
    val btnView: View = Button()
    btnView.click() // 重写函数，具体调用哪个方法，由实现类来决定的
    // Button Click

    btnView.showOff()  // 扩展函数并不存在重写，由声明的类型决定。
    // I'm a View!

}



