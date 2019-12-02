package org.logan.test.kotlin.basic.cp10

import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize

/**
 * desc: 使用jkid库 处理json <br/>
 * 1，serialize()：将对象转换为json字符串
 * 2，deserialize()：将json字符串转换为对象
 *
 * time: 2019-09-07 16:38 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

data class Person(val name: String, val age: Int)

fun main(args: Array<String>) {

    val person = Person("Alice", 29)
    println(serialize(person)) // 使用serialize将对象转换为json字符串

    val json = """ {"name": "Alice", "age": 29} """
    println(deserialize<Person>(json)) // 使用deserialize将json字符串转换为对象
}