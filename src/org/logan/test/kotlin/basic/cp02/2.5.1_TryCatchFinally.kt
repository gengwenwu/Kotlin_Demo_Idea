package org.logan.test.kotlin.basic.cp02

import java.io.BufferedReader
import java.io.StringReader

/**
 * desc: Kotlin异常结构与Java类似，区别如下：<br/>
 * 1，try、throw是一个表达式。<br/>
 * 2，与Java最大的区别在于没有throws子句。<br/>
 * 3，Kotlin不区分受检异常和非受检异常，不用指定函数抛出的异常，而且可以处理也可以不处理异常。<br/>
 *-
 * time: 2019-08-25 15:58 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    doThrowIsAnExpression()

    readNumber(BufferedReader(StringReader("not a number")))

    readNumber2(BufferedReader(StringReader("not a number")))

    readNumber3(BufferedReader(StringReader("not a number")))

}


fun doThrowIsAnExpression() { // 不必显示地指定这个函数可能抛出的异常
    val number = 10

    val percentage =
        if (1 in 0..10)
            number
        else
            throw IllegalArgumentException("Error")  // throw结构是一个表达式，能作为另外一个表达式的一部分使用
}

// try、catch、finally
fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) { // 异常类型在右边
        return null;
    } finally { // finally作用和java一样
        reader.close()
    }
}

// try表达式 - catch return
fun readNumber2(reader: BufferedReader) {
    val number = try { // 变成try表达式，花括号不能省略。与if 不同之处
        Integer.parseInt(reader.readLine())
    } catch (e: java.lang.NumberFormatException) {
        return // 执行该句后，后面代码不会被执行
    }

    println(number)
}

// try表达式 - catch null
fun readNumber3(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: java.lang.NumberFormatException) {
        null // 执行该句后，后面的代码还会继续执行
    }

    println(number)
}
