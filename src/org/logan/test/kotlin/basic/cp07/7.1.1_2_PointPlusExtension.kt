package org.logan.test.kotlin.basic.cp07.ext

/**
 * desc: 重载二元算术运算，plus -> + <br/>
 *       把运算符定义为扩展函数
 *
 * time: 2019/12/4 4:17 PM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

data class Point(val x: Int, val y: Int) {

}

operator fun Point.plus(other: Point): Point {
    return Point(x + other.x, y + other.y)
}


fun main(args: Array<String>) {
    val p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2) // 通过+号调用，实际调用plus函数。
}