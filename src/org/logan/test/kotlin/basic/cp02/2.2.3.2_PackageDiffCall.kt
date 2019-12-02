package org.logan.test.kotlin.basic.cp02


// Kotlin不区分导入的是类还是函数，而且它允许使用import导入任何类的声明。
// 直接导入顶层函数的名称。
import org.logan.test.kotlin.basic.cp02.ext.createRandomRectangle

// 注意这种星号导入不仅让包中定义的类可见、也会让顶层函数和属性可见。
// import org.logan.test.kotlin.basic.cp02.ext.*

/**
 * desc: 导入类 <br/>
 * time: 2019-08-22 17:14 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    val rectangle = createRandomRectangle()
    println(rectangle.isSquare)

}