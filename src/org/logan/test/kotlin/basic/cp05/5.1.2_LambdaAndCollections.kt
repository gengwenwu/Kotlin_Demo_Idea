package org.logan.test.kotlin.basic.cp05

/**
 * desc: lambda表达式的经典用途：和集合一起工作。 <br/>
 * time: 2019-09-05 11:50 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

data class Person(val name: String, val age: Int)

/* 手动在集合中搜索 */
fun findTheOldest(people: List<Person>) {
    val maxAge = 0
    var theOldest: Person? = null

    for (person in people) {
        if (person.age > maxAge) {
            theOldest = person
        }
    }

    println(theOldest)
}

fun main(args: Array<String>) {

    val people = listOf(Person("Alice", 20), Person("Bob", 31))
    findTheOldest(people)


    /**
     * 用lambda在集合中搜索 (比较年龄找出最大的元素)
     **/
    println(people.maxBy { it.age }) // {it.age}实现了这个逻辑的lambda，it指的是Person对象。


    // 如果lambda刚好是"函数"或者"属性的委托"，可以用"成员引用"替代（符号是::）
    println(people.maxBy(Person::age))

}