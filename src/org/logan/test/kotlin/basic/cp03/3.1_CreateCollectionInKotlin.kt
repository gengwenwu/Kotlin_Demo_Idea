package org.logan.test.kotlin.basic.cp03

/**
 * desc: Kotlin 中创建集合 <br/>
 * Kotlin没有采用自己的集合类，而是采用Java标准库中的集合类。<br/>
 * 因为使用标准Java集合类，Kotlin可以更容易与Java代码交互。<br/>
 * 尽管Kotlin的集合类和Java的集合类完全一致，但Kotlin为集合提供了更多的api。<br/>
 * time: 2019-08-25 20:23 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    createCollections()

    showNewApiInKotlin()
}


fun createCollections() {
    // 创建 HashSet
    val set = hashSetOf(1, 7, 53)
    println(set.javaClass)

    // 创建 ArrayList
    val list = arrayListOf(1, 7, 53)
    println(list.javaClass)

    // 创建 HashMap (下面to并不是一个特殊的结构，而是一个普通的函数，后期章节会细讲)
    val map = hashMapOf(1 to "One", 7 to "Seven", 53 to "fifity-three")
    println(map.javaClass)
}


fun showNewApiInKotlin() {

    val strings = listOf("first", "second", "fourteenth")
    println(strings.last()) // 最后一个元素

    val numbers = setOf(1, 14, 2)
    println(numbers.max()) // 最大值

}