package org.logan.test.kotlin.basic.cp05

/**
 * desc: Kotlin groupBy() <br/>
 * 该函数可以根据某个条件分组称一个Map<key, List<Value>>类型，其中key就是分组的条件。
 *
 * time: 2019-09-18 15:36 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {
    val people = listOf(
        Person("Alice", 27),
        Person("Bob", 31),
        Person("Carol", 31)
    )

    val map: Map<Int, List<Person>> = people.groupBy { it.age }
    for ((age, list) in map) {
        print("key: ${age} = [")

        for (person in list) {
            print("${person.name}, ")
        }

        println("]")
    }


    //  first 是 String类的扩展函数
    val list = listOf("a", "ab", "b")
    println(list.groupBy(String::first))

}
