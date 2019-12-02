package org.logan.test.kotlin.basic.cp02

/**
 * desc: Kotlin 声明class类、及使用，可与Java版本做对比(请搜索Java版Person做对比) <br/>
 * time: 2019-08-22 15:07 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Person( // 依旧使用class 关键字
    val name: String, // 只读属性，只生成getter
    var isMarried: Boolean //可写属性，生成getter 和 setter
)


fun main(args: Array<String>) {

    /**
     * 在Kotlin中使用Person类。
     * Kotlin在形式上直接调用属性和设值属性(底层使用的是访问器)。
     **/
    val person = Person("Logan", false) // 实例化不需要关键字new
    println(person.name) // 可以直接访问属性，但实际调用的是getter
    person.isMarried = true // 实际调用的是setter

}