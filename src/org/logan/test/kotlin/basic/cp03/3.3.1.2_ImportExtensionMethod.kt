package org.logan.test.kotlin.basic.cp03.ext

import org.logan.test.kotlin.basic.cp03.lastChar // 1，导入扩展函数

// import org.logan.test.kotlin.basic.cp03.*  // 2，使用*导入
// import org.logan.test.kotlin.basic.cp03.lastChar as last  // 3，重命名导入的类或函数

/**
 * desc: 导入扩展函数 <br/>
 * 1, Kotlin允许用导入类一样的语法来导入单个函数。<br/>
 * 2，使用 * 导入。<br/>
 * 3, 使用 as 重命名。在不同的包中，有一些重名的函数时，在导入时给它重新命名就显得很有必要。<br/>
 * -
 * time: 2019-08-26 16:18 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main(args: Array<String>) {

    val c = "Kotlin".lastChar()
    // val c = "Kotlin".last() // 第3种方式

}