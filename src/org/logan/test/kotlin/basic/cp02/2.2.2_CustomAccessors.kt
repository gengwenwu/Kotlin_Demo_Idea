package org.logan.test.kotlin.basic.cp02

/**
 * desc: Kotlin 自定义访问器。使用 get() 关键字 <br/>
 * 1，自定义getter，建议使用val声明变量，不会生成成员变量。<br/>
 * 2，自定义setter，必须使用var声明变量，会生成成员变量。<br/>
 * 3，在自定义访问器里面，可以使用 field 关键字，访问原始值。也就是意味着使用 field 会生成成员变量。
 *
 * time: 2019-08-22 15:31 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Rectangle(val height: Int, val width: Int) {

    val isSquare: Boolean
        get() { // 声明属性的getter （代码块 形式）
            return height == width
        }


    var isRectangle: Boolean // = false // 配合 field 一起使用
        // 声明属性的getter (表达式 形式)
        get() = (height > width) || (width > height)
        // 声明属性 setter
        set(value) {
            // field = value // 使用 field 关键字，会自动生成成员变量。
        }

    // 这里有一个疑问，声明一个没有参数的函数(isSquare())，是否比声明带自定义getter的属性更好(isMarried())？
    // 这两种方式几乎一样的：实现和性能没有差别，唯一的差异是可读性。
    // 通常来说，如果描述的是类的特征（属性），应该把它声明成属性。

}