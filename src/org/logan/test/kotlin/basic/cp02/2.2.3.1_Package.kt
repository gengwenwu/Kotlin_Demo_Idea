package org.logan.test.kotlin.basic.cp02.ext

// Kotlin包层级结构不需要遵循文件目录层级结构，如上。但建议：遵循Java的目录布局并根据包结构把源文件放到目录中。<br/>
// 每一个Kotlin文件都以一条package语句开头，而文件中定义的所有声明（类、函数及属性）都会被放到这个包中。<br/>
// 如果其它文件中定义的声明也有相同的包，这个文件可以直接使用它们。<br/>

// 关键字import导入包。
import java.util.*

/**
 * desc: Kotlin包目录结构 <br/>
 * time: 2019-08-22 15:43 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Rectangle(val height: Int, val width: Int) {

    val isSquare: Boolean
        get() = height == width

}


fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}