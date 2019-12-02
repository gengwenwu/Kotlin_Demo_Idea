package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin object关键字用法2 - 伴生对象 companion object，其它用法。 <br/>
 * 1，指定伴身对象名称。<br/>
 * 2，伴生对象实现接口。<br/>
 * 3，伴生对象容器名称作为参数传递。<br/>
 *
 * time: 2019-09-03 11:50 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Person2 private constructor(val name: String) {

    companion object Loader { // 可以指明伴生对象名称(如这里的Loader)，默认是Companion名称
        fun fromJSON(jsonText: String): Person2 = Person2(jsonText)
    }
}


// 在伴生对象中实现接口
interface JSONFactory<T> {
    fun fromJSON(jsonText: String): T
}

class Person10(val name: String) {
    companion object : JSONFactory<Person2> {
        // 实现接口的伴生对象
        override fun fromJSON(jsonText: String): Person2 = Person2.fromJSON(jsonText)
    }
}

fun <T> loadFromJSON(factory: JSONFactory<T>): T? {
    return null;
}


fun main(args: Array<String>) {
    // 调用方式一：通过指定的名称调用
    val person = Person2.Loader.fromJSON("Alice")
    println(person.name)

    // 调用方式二：通过容器类名直接调用
    val person2 = Person2.fromJSON("Bob")
    println(person2.name)


    // 将伴生对象实例传入函数中，Person类的名字被当作JSONFactory的实例传递。
    loadFromJSON(Person10)

}