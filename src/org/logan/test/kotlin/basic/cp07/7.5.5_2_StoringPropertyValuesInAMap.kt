package org.logan.test.kotlin.basic.cp07.ext7552

/**
 * desc: 托属性发挥作用的另一种常见用法，是用在有动态定义的属性集的对象中。 <br/>
 *       优化7.5.5_1_ExpandoObject.kt例子
 *
 * time: 2019/12/17 4:20 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Person {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    // 优化：把map作为使用委托属性。
    //      因为标准库己经在标准 Map 和 MutableMap 接口上定义了 getValue 和 setValue 扩展函数，所以这里可以直接这样用。
    //      属性的名称将自动用作在map中的健，属性值作为map中的值。
    val name: String by _attributes
}

fun main() {
    val p = Person()
    val data = mapOf("name" to "Alice", "company" to "JetBrains")

    for ((attrName, value) in data) {
        p.setAttribute(attrName, value) // 设置属性
    }

    println(p.name) // p.name隐藏了 attributes.getValue(p, prop)的调用。这里变为 _attributes[prop.name]。
}