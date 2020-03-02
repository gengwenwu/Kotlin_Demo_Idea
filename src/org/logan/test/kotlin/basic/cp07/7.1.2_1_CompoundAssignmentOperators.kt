package org.logan.test.kotlin.basic.cp07

/**
 * desc: 重载 复合赋值运算符(+=、-=) <br/>
 *       当定义像 plus 这样的运算符函数时，Kotlin不仅支持+号运算，也支持+=，即：复合赋值运算符。
 *
 * time: 2019/12/5 3:24 PM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {
    var point = Point(1, 2)
    point += Point(3, 4) // 等同于 point= point + Point(3, 4)
    println(point)


    // 在一些情况下，定义+=运算可以修改使用它的变量所引用的对象，但不会重新分配引用。
    // 将一个元素添加到可变集合，就是一个很好的例子 :
    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers[0])

    // 如果定义了一个返回值为 Unit，名为 plusAssign 的函数，Kotlin将会在用到+=运算符的地方调用它。
    // 其他二元算术运算符也有命名相似的对应函数：
    //    minusAssign -》 -=
    //    timesAssign -》 *=
    // 等，Kotlin标准库为可变集合定义了plusAssign()、minusAssign()等函数

}

