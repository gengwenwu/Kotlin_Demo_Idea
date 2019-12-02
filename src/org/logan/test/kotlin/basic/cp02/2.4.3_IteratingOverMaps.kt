package org.logan.test.kotlin.basic.cp02

import java.util.*

/**
 * desc: in 遍历map <br/>
 * time: 2019-08-23 14:49 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    val binaryRes = TreeMap<Char, String>() // TreeMap让Key排序

    for (c in 'A'..'F') { // ..语法不仅可以创建数字区间、还可以创建字符区间
        val binary = Integer.toBinaryString(c.toInt())
        binaryRes[c] = binary // 使用map[key]=value设置值，也可以使用map[key]读取值，不需要调用get和put。
    }

    // 迭代Map，把key，value赋给两个变量，分别是letter，
    for ((letter, binary) in binaryRes) {
        println("Map -》 $letter = $binary")
    }


    val list = arrayListOf("10", "11", "1001")

    // 使用in 遍历 list， index是下标、element是元素
    for ((index, element) in list.withIndex()) {
        println("List -》$index : $element")
    }

}