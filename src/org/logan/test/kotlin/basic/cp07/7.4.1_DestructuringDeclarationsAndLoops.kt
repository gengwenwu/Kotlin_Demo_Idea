package org.logan.test.kotlin.basic.cp07

/**
 * desc: 解构声明不仅可以用作函数中的顶层语句，还可以用在其他可以声明变量的地方，例如: in 循环。 <br/>
 *
 * time: 2019/12/13 3:03 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {// 在 in 循环中解构声明
        println("$key -> $value")
    }

    // 上面例子用到了两个 Kotlin 约定 : 一个是迭代一个对象：in，另一个是用于解构声明：(key, value)。
    // Kotlin 标准库给 map 增加了一个扩展的 iterator 函数，用来返回 map 条目的迭代器。因此，与Java不同的是，可以直接送代map。
    // 它还包含 Map. Entry上的扩展函数 component1 和 component2，分别返回它的键和值。实际上，前面的循环被转换成了这样的代码:
    for (entry in map.entries){
        val key = entry.component1()
        val value = entry.component2()
    }
}

fun main() {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}
