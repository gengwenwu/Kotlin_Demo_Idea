package org.logan.test.kotlin.basic.cp07

/**
 * desc: 通过下标来访问元素：“set” <br/>
 * time: 2019/12/12 2:50 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when (index) {
        0 -> x = value // 根据输出的index修改对应的坐标
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index ")
    }
}

fun main() {
    val p = MutablePoint(10, 20)
    p[1] = 42 // 实际调用的是MutablePoint.set(1, 42) 函数
    println(p)

    // x[a, b]=c -> x.set(a, b, c) // 括号的赋值操作将会转换为 set 函数的调用
}