package org.logan.test.kotlin.basic.cp07

import org.logan.test.kotlin.basic.cp07.ext.Point

/**
 * desc: 在定义一个运算符的时候，不要求两个运算数是相同的类型。<br/>
 *
 * time: 2019/12/5 2:17 PM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

operator fun Point.times(scale: Double): Point { // double类型
    return Point((x * scale).toInt(), (y * scale).toInt())
}

// 从这个函数可以看出，和普通的函数一样，可以重载 operator函数: 可以定义多个同名的，但参数类型不同的方法。
operator fun Double.times(p: Point): Point { // 支持交换性
    return Point((this * p.x).toInt(), (this * p.y).toInt())
}

fun main(args: Array<String>) {
    val p = Point(10, 20)
    println(p * 1.5) //  调用 times(Double) 函数
    println(1.5 * p) //  Kotlin运算符不会自动支持交换性 (交换运算符的左右两边)，调用的是times(Point)
}
