package org.logan.test.kotlin.basic.cp05

/**
 * desc: 函数 all、any、count、find <br/>
 * time: 2019-09-18 15:14 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {
    var canBeInClub27 = { p: Person -> p.age <= 27 }
    val people = listOf(Person("Alice", 27), Person("Bob", 31))

    // all()：所有条件都要满足
    println(people.all(canBeInClub27)) // 输出false


    // all()：只要有一个条件满足即可
    println(people.any(canBeInClub27)) // 输出true


    // count()：多少个数满足条件
    println(people.count(canBeInClub27)) // 输出1

    println(people.filter(canBeInClub27).size) // 输出1，但是性能不如count()，因为filter操作创建了一个集合


    // find()：查找第一个满足条件的数据，返回数据，并终止便利搜索。
    println(people.find(canBeInClub27)) //输出： Person(name=Alice, age=27)
    println(people.firstOrNull { it.age > 100 }) //输出 null


    /**
     * !all (“不是所有”)加上某个条件，可以用 any 加上这个条件的取反来替换。
     * 但是为了让代码更容易理解，尽量少用否定符号
     **/
    val list = listOf(1, 2, 3)
    println(!list.all { it == 3 }) // true
    println(list.any { it != 3 }) // true


}