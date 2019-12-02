package org.logan.test.kotlin.basic.cp03

/**
 * desc: Kotlin正则表达式 <br/>
 * time: 2019-08-27 14:25 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun main(args: Array<String>) {

    // Kotlin 支持英文点号
    println("12.345-6.A".split("[.-]".toRegex())) // toRegex()转换成正则表达式对象


    // Kotlin可以指定多个分隔符
    println("12.345-6.A".split(".", "-"))

}