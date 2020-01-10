package org.logan.test.kotlin.basic.cp09

/**
 * desc: 为什么存在变型: 给函数传递实参 <br/>
 * time: 2020/1/10 11:27 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun printContents(list: List<Any>) { // 只读List
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>) { // 可变List
    list.add(2)
}

fun main() {
    // 函数把每个元素都当成 Any 对待，而且因为每一个字符串都是 Any，这是完全安全的。
    printContents(listOf("abc", "bac"))


    val strings = mutableListOf("abc", "bac")
    // addAnswer(strings) // 编译错误: Required MutableList<Any>，Found MutableList<String>
    // 这个例子展示了当期望的是 MutableList<Any> 的时候把一个 MutableList<String> 当作实参传递是不安全的，编译不通过。


    // 把一个字符串列表传给期望 Any 对象列表的函数是否安全？
    // 如果函数添加 或者 替换了列表中的元素就是不安全的(可变集合)，因为这样会产生类型不一致的可能性。
    // 否则它就是安全的，即：只读集合 (本节稍后将会更详细地讨论其原因) 。

    // 在 Kotlin 中，这可以通过根据列表 是否可变 选择合适的接口来轻易地控制。
    // 如果函数接收的是只读列表，可以传递具有更具体的元素类型的列表。如果列表是可变的，就不能这样做。
    // 同样的问题推广到任何泛型类，而不仅仅是 List。

}