package org.logan.test.kotlin.basic.cp06

import java.io.BufferedReader

/**
 * desc: 可空性和集合，Kotlin完全支持类型参数的可空性。
 * 就像变量的类型可以加上？字符来表示变量可以持有null一样，类型在被当作类型参数时也可以用同样的方式标记。
 *
 * time: 2019-11-28 14:42 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 创建一个包含可空值的集合
fun readNumbers(reader: BufferedReader): List<Int?> {
    // List<Int?>  : 列表本身始终不为 null，列表中的单个值是可空的。
    // List<Int>?  : 列表本身始终是可空的，整个列表不为null。
    // List<Int?>? : 列表本身和其中的值都有可能为null

    val result = ArrayList<Int?>() // 创建包含可空Int值的列表
    for (line in reader.lineSequence()) {

        try {
            val number = line.toInt() //  line.toIntOrNull()
            result.add(number) // 向列表添加数值
        } catch (e: NumberFormatException) {
            result.add(null) // 向列表添加null
        }
    }

    return result
}

// 使用可空值的集合
fun addValidNumbers(numbers: List<Int?>) {
    var sumOfValidNumbers = 0
    var invalidNumbers = 0

    for (number in numbers) {
        if (number != null) {
            sumOfValidNumbers += number // 从列表中读取可空值
        } else {
            invalidNumbers++ // 检查值是否为null
        }
    }

    println("Sum of valid numbers: $sumOfValidNumbers")
    println("Invalid numbers: $invalidNumbers")
}

// 对包含可空值的集合使用filterNotNull()
fun addValidNumbers2(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull() // 过滤掉 null
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun main(args: Array<String>) {
    // val reader = BufferedReader(StringReader("1/abc/42"))
    // val numbers = readNumbers(reader)
    //  addValidNumbers(numbers)
}