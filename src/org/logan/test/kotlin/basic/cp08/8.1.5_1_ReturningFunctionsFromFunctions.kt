package org.logan.test.kotlin.basic.cp08

/**
 * desc: 返回函数的函数 <br/>
 * time: 2019/12/19 6:37 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

enum class Delivery {
    STANDARD, EXPEDITED
}

class Order(val itemCount: Int)


fun getShippingCostCalculator(
    delivery: Delivery
): (Order) -> Double { // 声明一个返回另一个函数的函数，需要指定一个函数类型作为返回类型。

    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount } // 返回Lambda
    }

    return { order -> 1.2 * order.itemCount } // 要返回一个函数，需要写一个 return 表达式，跟上一个lambda、一个成员引用，
    //                                        // 或者其他的函数类型的表达式， 比如一个(函数类型的)局部变量。
}

fun main() {
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED) // Delivery.EXPEDITED
    println("Shipping costs ${calculator(Order(3))}")

}