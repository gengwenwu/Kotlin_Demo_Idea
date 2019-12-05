package org.logan.test.kotlin.basic.cp07.ext

/**
 * desc: 重载二元算术运算，plus -> + <br/>
 *       把运算符定义为扩展函数
 *
 * Kotlin 限定了你能重载哪些运算符，以及你需要在你的类中定义的对应名字的函数。二元运算符，以及对应的函数名称。如下：
 * (1)，a * b -> times
 * (2)，a / b -> div
 * (3)，a % b -> mod
 * (4)，a + b -> plus
 * (5)，a - b -> minus
 *
 *
 * 自定义类型的运算符，基本上和与标准数字类型 的运算符有着相同的优先级。
 *
 *
 * 运算符函数和 Java
 * 从Java调用Kotlin运算符非常容易：因为每个重载的运算符都被定义为一个函数，可以像普通函数那样调用它们。
 * 当从 Kotlin调用 Java的时候，对于与 Kotlin约定匹配的函数都可以使用运算符语法来调用。
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