package org.logan.test.kotlin.basic.cp03

/**
 * desc: 中缀调用 与 解构声明 <br/>
 * 一，中缀调用
 *      1，使用infix声明函数。如：TuplesKt.to() <br/>
 *      2，在中缀调用中，没有添加额外的分隔符，函数名称是直接放在目标对象名称和参数之间。 <br/>
 *      3，中缀调用可以与 只有一个参数 的函数一起使用，无论是普通的函数还是扩展函数。<br/>
 *******
 * 二，解构声明: 解析对象并声明变量。如：Pairs
 *
 * time: 2019-08-27 14:07 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    // 单词to不是内置的结构，而是一种特殊的函数调用，被称为中缀调用。to函数 使用infix声明
    val map = mapOf(1 to "one", 7 to "server")

    // 下面两个效果是一致的
    // 1.to("one") //一般to函数的调用
    // 1 to "one" // 使用中缀符号调用to函数


    // 这个功能称为解构声明 (解析对象并声明变量：解析Pair并声明了number,name变量)
    val (number, name) = 1 to "one"

    // 解析声明：适用于循环
    for ((index, element) in listOf(1, 2, 3).withIndex()) {
        println("${index} -> ${element}")
    }

}