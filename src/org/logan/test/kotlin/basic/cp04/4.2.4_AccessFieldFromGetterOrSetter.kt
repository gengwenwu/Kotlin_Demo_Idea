package org.logan.test.kotlin.basic.cp04.ext

/**
 * desc: 通过getter和setter访问支持字段 <br/>
 * 特殊的标识符field来访问支持字段的值。在getter中，只能读取值；而在setter中，既能读取它也能修改它。<br/>
 * time: 2019-09-01 17:02 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class User(val name: String) {

    var address: String = "unspecified"
        set(value: String) {
            // 读取支持字段的值
            println("""Address was changed for $name "$field" -> "$value".""".trimIndent())

            //  更新支持字段的值
            field = value
        }
}

fun main(args: Array<String>) {
    val user = User("Alice")
    user.address = "China"

}