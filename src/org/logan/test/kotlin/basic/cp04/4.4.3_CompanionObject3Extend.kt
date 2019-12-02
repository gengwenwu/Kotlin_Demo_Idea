package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin object关键字用法2 - 伴生对象的，扩展函数。 <br/>

 *
 * time: 2019-09-03 11:50 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Person3(val name: String) {

    companion object { // 为了能够为伴生对象定义扩展函数，必须在其中声明一个伴生对象，即使是一个空的。

    }
}

// 给伴身对象声明一个扩展函数，注意写法，多了一个Companion名称
fun Person3.Companion.fromJSON(json: String): Person? = null


fun main(args: Array<String>) {
    // 调用fromJSON就好像它是一个伴生对象定义的方法一样
    val p = Person3.fromJSON("{'nickname': 'Alice'}")
}