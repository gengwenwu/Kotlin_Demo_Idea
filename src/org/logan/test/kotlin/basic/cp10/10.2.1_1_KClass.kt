package org.logan.test.kotlin.basic.cp10

import kotlin.reflect.full.memberProperties

/**
 * desc: Kotlin反射API - KClass <br/>
 * Kotlin反射API的主要入口就是KClass，它代表了一个类。
 * KClass对应的是java.lang.class，可以用它列举和访问类中包含的所有声明，然后是它的超类中的声明等等。
 *
 * MyClass::class的写法会带给你一个 KClass的实例。
 *
 * time: 2019-09-08 09:42 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {
    val person = Person("Alice", 29)

    /**
     * javaClass属性获得它的 Java类，等价于 Java中的java.lang.Object.getClass()。
     * 然后访问该类的.kotlin扩展属性，从Java切换到 Kotlin的反射 API:
     **/
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName) //  输出 Person

    // memberProperties，获取Person中所有的非扩展属性
    kClass.memberProperties.forEach {
        println(it.name) // 输出 age 和 name 成员属性
    }

}