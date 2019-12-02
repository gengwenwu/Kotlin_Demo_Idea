package org.logan.test.kotlin.basic.cp10

import ru.yole.jkid.JsonExclude
import ru.yole.jkid.JsonName
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize

/**
 * desc: jkid库 使用注解自定义解析过程 <br/>
 * 1，@JsonName()：指定别名
 * 2，@JsonExclude()：排除指定字段在序列化和反序列化之外。
 *
 * time: 2019-09-07 16:45 <br/>
 * author: Logan <br/>
 * since V 1。0 <br/>
 */
data class Person2(
    // 使用 @JsonName 指定新名称
    @JsonName("alias") val firstName: String,
    // 使用 @JsonExclude 排除字段
    @JsonExclude val age: Int? = null // 注意，必须指定age的默认值。否则，在反序列化时你无法创建一个Person的新实例。
)

fun main(args: Array<String>) {
    val json = """ {"alias": "Alice", "age": 29} """
    val person = deserialize<Person2>(json)

    println(person) // 输出：Person2(firstName=Alice, age=29)
    println(serialize(person)) // 输出：{"alias": "Alice"}

}