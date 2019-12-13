package org.logan.test.kotlin.basic.cp07

/**
 * desc: 解构声明 主要使用场景之一：是从一个函数返回多个值，这个非常有用。<br/>
 * 如果要这样做，可以定义一个数据类来保存返回所需的值，并将它作为函数的返回类型。
 * 在调用函数后，可以用解构声明的方式，来轻松地展开它，使用其中的值。
 *
 * 不可能定义无限数量的 componentN 函数，标准库只允许使用此语法来访问一个对象的前五个元素。
 *
 * 让一个函数能返回多个值有更简单的方法，是使用标准库中的 Pair 和 Triple 类。在语义表达上这种方式会差一点，但可以减少代码。
 *
 * time: 2019/12/13 2:36 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 声明一个数据类来持有值
data class NameComponents(
    val name: String, // 注意：这些属性要写在主构造函数中，才能被生成 componentN() 函数
    val extension: String
)

fun splitFilename(fulName: String): NameComponents {
    val result = fulName.split(".", limit = 2)
    return NameComponents(result[0], result[1]) // 返回一个数据类型的实例
}

// componentN() 在数组和集合上也有定义，当你在处理己知大小的集合时，这是非常有用的。
fun splitFilename2(fullName: String): NameComponents {
    // 返回已知数组大小的数组，声明name、extension变量并赋值
    val (name, extension) = fullName.split(".", limit = 2)
    return NameComponents(name, extension)
}

fun main() {
    val (name, ext) = splitFilename("example.txt") // 使用解构声明来展开NameComponents类
    println("${name}, ${ext}")

}