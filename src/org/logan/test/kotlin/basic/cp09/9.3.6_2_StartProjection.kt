package org.logan.test.kotlin.basic.cp09

/**
 * desc: 星号投影: 使用*代替类型参数 <br/>
 * 星号投影的语法很简沽，但只能用在对泛型类型实参的确切值不感兴趣的地方:
 * 只是使用生产值的方法，而且不关心那些值的类型。
 *
 * time: 2020/3/11 11:24 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 当类型实参的信息并不重要的时候，可以使用星号投影的语法:
// 不需要使用范型类型参数的方法，或者只是读取数据而不关心它的具体类型。如下：
fun printFirst(list: List<*>) { // 每一种列表都是可能的实参
    if (list.isNotEmpty()) { // isNotEmpty() 没有使用范型类型参数
        println(list.first()) // first() 现在返回的是Any?，这样足够了。
    }
}

// 使用范型类参数 替代上面的List<*>方式
fun <T> printFirst2(list: List<T>) { // 再一次，每一种列表都是可能的实参
    if (list.isNotEmpty()) {
        println(list.first()) // first() 返回的是T的值
    }
}

fun main() {
    printFirst(listOf("Alice", "Logan"))
    printFirst2(listOf("Alice", "Logan"))
}

