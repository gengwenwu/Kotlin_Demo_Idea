package org.logan.test.kotlin.basic.cp05



/**
 * desc: filter 和 map <br/>
 * filter 和 map 函数组成了操作集合的基础。针对映射类型也做了支持。
 *
 * time: 2019-09-07 11:38 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */


fun main(args: Array<String>) {

    // 1， filter
    val list = listOf(1, 2, 3, 4)
    list.filter { it % 2 == 0 } // 只保留偶数，即：[2, 4]


    // 2，filter
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    people.filter { it.age > 30 } // [Person("Bob", 31)]


    // 3，map
    list.map { it * it }  // [1, 4, 9, 16]

    // 4，map
    people.map { it.name } // [Alice, Bob]
    people.map { Person::age } // 使用成员引用


    // 5, 效率问题 (找出组中年纪最大的人)
    // 下面代码为每个人重复了最大年龄的查找步骤。所以，如果集合中有100个人，最大年龄的搜索将会执行100次！
    people.filter { it.age == people.maxBy(Person::age)?.age }

    val maxAge = people.maxBy { it.age }?.age // 只计算一次最大年龄
    people.filter { it.age == maxAge }


    /**
     * 6，kotlin针对映射类型提供了过滤和变换的函数，如：map，针对它的key和value操作。
     * filterKeys、mapKeys 过滤key。filterValues 、mapValues 过滤和变换对应的value。
     **/
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() }) // {0=ZERO, 1=ONE}

}


