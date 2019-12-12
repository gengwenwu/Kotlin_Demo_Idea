package org.logan.test.kotlin.basic.cp07

/**
 * desc: “in”运算符的约定: contains() <br/>
 * in运算符，用于检查某个对象是否属于集合。相应的函数叫作contains()。
 * a in c -->  c.contains(a)
 *
 * time: 2019/12/12 5:20 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

data class Rectangle(val upperLeft: Point, val lowerRight: Point)


operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x // 构造一个区间，检查坐标x是否属于这个区间
            && p.y in upperLeft.y until lowerRight.y
}

fun main() {
    val rect = Rectangle(Point(10, 20), Point(50, 50))
    println(Point(20, 30) in rect) // 调用 Rectangle.contains()
    println(Point(5, 5) in rect)

}