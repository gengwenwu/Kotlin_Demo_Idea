package org.logan.test.kotlin.basic.cp07

/**
 * desc: Kotlin没有用于位运算的特殊运算符 <br/>
 * 因此，也不允许你为自定义类型定义它们。 相反，它使用支持中级调用语法的常规函数，可以为自定义类型定义相似的函数。
 *  Kotlin提供的，用于执行位运算的完整函数列表:
 *      shl  - 带符号左移
 *      shr  - 带符号右移
 *      ushr - 无符号右移
 *      and  - 按位与
 *      or   - 按位异或
 *      inv  - 按位取反
 *
 * time: 2019/12/5 3:03 PM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main(args: Array<String>) {
    println(0x0F and 0xF0)
    println(0x0F or 0xF0)
    println(0x0F shl 0xF0)

}