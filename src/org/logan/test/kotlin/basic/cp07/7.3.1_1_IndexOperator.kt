package org.logan.test.kotlin.basic.cp07

/**
 * desc: 通过下标来访问元素：“get”  <br/>
 * 语法 a[b] (称为：下标运算符)
 *
 *  定义一个名为 get 的函数，并标记 operator，就可以使用下标运算符调用了。<br/>
 *  get函数的参数可以是任何类型，任意个数。也可以定义多个重载的 get方法。<br/>
 *
 * time: 2019/12/12 2:10 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 定义一个名为 get 的函数，并标记 operator。就可以使用下标运算符调用了。
operator fun Point.get(index: Int): Int { //
    return when (index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

fun main() {
    val p = Point(10, 20)
    println(p[1]) // p[1]实际调用的是Point.get(1)函数

    // x[a, b] -> x.get(a, b) // 方括号的访问会被转换为 get函数的调用


}