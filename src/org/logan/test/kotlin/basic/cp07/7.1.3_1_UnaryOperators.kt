package org.logan.test.kotlin.basic.cp07

/**
 * desc: 重载一元运算符 <br/>
 *       其过程:用预先定义的一个名称来声明函数(成员函数或扩展函数)，并用修饰符 operator 标记。
 *
 * 可重载的一元算法的运算符：
 *      +a : unaryPlus()
 *      -a : unaryMinus()
 *      !a : not()
 *      ++a, a++ : inc()
 *      --a, a-- : dec()
 *
 * time: 2019/12/11 2:49 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

operator fun Point.unaryMinus(): Point { // 一元运算符无参数
    return Point(-x, -y) // 坐标取反并返回
}

fun main() {
    val p = Point(10, 20)
    println(-p) // 调用Point的unaryMinus()函数
}