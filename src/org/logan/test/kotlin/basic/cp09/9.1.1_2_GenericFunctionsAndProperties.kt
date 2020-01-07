package org.logan.test.kotlin.basic.cp09

/**
 * desc: 泛型扩展属性 <br/>
 *
 * time: 2020/1/7 11:48 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 声明泛型的扩展属性(语法与范型函数一样)
val <T> List<T>.penultimate: T
    get() = this[size - 2] // 返回列表倒数第二个元素


fun main() {
    println(listOf(1, 2, 3, 4).penultimate)

    // 注意：不能声明泛型非扩展属性。普通(即非扩展)属性不能拥有类型参数，不能在一个类的属性中存储多个不同类型的值，
    // 因此声明泛型非扩展函数没有任何意义。如下：
    // val <T> x: T = TODO() // 编译报错
}