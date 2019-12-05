package org.logan.test.kotlin.basic.cp07

/**
 * desc: 复合赋值运算符兼容性 <br/>
 * 当在代码中用到 += 的时候，plus 和 plusAssign 都可能被调用。在这种情况下，两个函数都有定义且适用，编译器会报错。<br/>
 * 一种可行的解决办法是，替换运算符的使用为普通函数调用。
 * 另一个办法是，用 val 替换 var，这样 plusAssign 运算就不再适用。<br/>
 *
 * 一般来说，尽量不要同时给一个类添加 plus 和 plusAssign 运算。
 * 如果像前面的一个示例中的 Point，这个类是不可变的，那么就应该只提供返回一个新值 (new 一个新对象)的运算(如 plus)。
 * 如果一个类是可变的，比如构建器，那么只需要提供 plusAssign 和类似的运算就够了。
 *
 * time: 2019/12/5 5:04 PM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    // Kotlin 标准库支持集合的这两种方法：
    // += 和 -= 运算符用于可变集合时，始终在一个地方修改它们；+ 和 - 运算符总是返回一个新的集合；
    val list = arrayListOf(1, 2)
    list += 3 // += 修改list

    val newList = list + listOf(4, 5) // 返回一个包含所有元素的新列表


    println(list)
    println(newList)

}