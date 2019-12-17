package org.logan.test.kotlin.basic.cp07.ext7551

/**
 * desc: 委托属性发挥作用的另一种常见用法，是用在有动态定义的属性集的对象中。<br/>
 *       优化见：7.5.5_2_StoringPropertyValuesInAMap.kt
 *
 * time: 2019/12/17 4:15 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Person {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    val name: String
        get() = _attributes["name"]!! // 从map中检索属性，在7.5.5_2_StoringPropertyValuesInAMap.kt有改进

}

fun main() {
    val p = Person()
    val data = mapOf("name" to "Alice", "company" to "JetBrains")

    for ((attrName, value) in data) {
        p.setAttribute(attrName, value) // 设置属性
    }

    println(p.name)

}