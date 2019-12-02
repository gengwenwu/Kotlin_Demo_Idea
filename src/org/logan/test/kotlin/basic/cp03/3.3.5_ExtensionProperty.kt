package org.logan.test.kotlin.basic.cp03

/**
 * desc: 扩展属性 - 用的是属性语法。<br/>
 * 尽管它们被称为属性，但它们可以没有任何状态， <br/>
 * 因为没有合适的地方存储它，不可能对现有的Java对象的实例添加额外的字段。<br/>
 * 同理，初始化也不可以，没有地方存储初始化值。<br/>
 * -
 * time: 2019-08-27 11:33 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// val变量的扩展属性，只能有getter。
val String.lastChar: Char
    get() = get(length - 1) // 只读扩展属性，即：getter


// var变量的扩展属性，getter、setter 必须都有。
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) { // 可变的扩展属性，即：setter。入参类型与变量类型必须保持一致
        this.setCharAt(length - 1, value)
    }


fun main(args: Array<String>) {

    // 可以像使用成员属性一样访问扩展属性
    println("Kotlin".lastChar)


    val sb = StringBuilder("Kotlin?")
    sb.lastChar = '!'
    println(sb)

}