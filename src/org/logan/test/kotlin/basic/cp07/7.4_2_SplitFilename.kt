package org.logan.test.kotlin.basic.cp07

/**
 * desc: 解构声明 主要使用场景之一：是从一个函数返回多个值，这个非常有用。<br/>
 * 如果要这样做，可以定义一个数据类来保存返回所需的值，并将它作为函数的返回类型。
 * 在调用函数后，可以用解构声明的方式，来轻松地展开它，使用其中的值。
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


fun main() {
    val (name, ext) = splitFilename("example.txt") // 使用解构声明来展开NameComponents类
    println("${name}, ${ext}")

}