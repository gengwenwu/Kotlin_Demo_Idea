package org.logan.test.kotlin.basic.cp10

import ru.yole.jkid.deserialization.deserialize

/**
 * desc: JDID反序列化 <br/>
 * time: 2019-09-10 15:03 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */


data class Author(val name: String)

data class Book(val title: String, val author: Author)


fun main(args: Array<String>) {
    val json = """{"title":"catch-22", "author":{"name":"J. Heller"}}"""
    val book = deserialize<Book>(json)

    println(book) // 输出Book(title=Catch-22, author=Author(name=J. Heller))
}