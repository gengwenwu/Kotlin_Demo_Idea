package org.logan.test.kotlin.basic.cp05

/**
 * desc: flatMap()、flatten() <br/>
 *
 * 1，flatMap()：首先根据作为实参给定的函数对集合中的每个元素做变换(或者说映射)，然后把多个列表合并(或者说平铺) 成一个列表。<br/>
 * 2，flatten()：如果你不需要做任何变换，只是需要平铺一个集合。<br/>
 *
 * time: 2019-09-18 16:08 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Book(val title: String, val authors: List<String>)

fun main(args: Array<String>) {

    val books = listOf(
        Book("Thursday Next", listOf("Jasper Fforde")),
        Book("Mort", listOf("Terry Pratchett")),
        Book("Good Omens", listOf("Terry Pratchett", " Neil Gaiman"))
    )

    // flatMap 函数把所有书籍的作者合并成了一个列表。 toSet 移除了集合的所有重复元素。
    println(books.flatMap { it.authors }.toSet())


    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() }) // 输出 [a, b, c, d, e, f]


    val list = listOf(listOf("Str1", "Str2"), listOf("Str3", "Str4"))
    println(list.flatMap { it }) // AS提示你使用flatten() ，
    println(list.flatten()) // flatten()只是需要平铺一个集合

}