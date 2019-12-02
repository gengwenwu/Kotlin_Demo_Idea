package org.logan.test.kotlin.basic.cp06

/**
 * desc: 安全转换运算符: as? <br/>
 * as运算符：如果被转换的值不是你试图转换的类型，就会抛出ClassCastException异常。<br/>
 * as?运算符：尝试把值转换成指定的类型，如果值不是合适的类型就返回 null。
 * 安全调用、安全转换 和 Elvis 运算符都非常有用，它们出现在 Kotlin 代码中的频率非常高。
 *
 * foo as? Type
 *      如果foo is Type，则foo强转成Type。
 *      如果foo !is Type， 则返回null
 *
 * time: 2019-09-22 19:17 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Person1(val firstName: String, val lastName: String) {

    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? Person1 ?: return false // 安全转换

        // 在安全转换之后变量，otherPerson 被智能地转换成Person类型
        return otherPerson.firstName == firstName
                && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

fun main(args: Array<String>) {
    val p1 = Person1("Dmitry", "Jemerov")
    val p2 = Person1("Dmitry", "Jemerov")
    println(p1 == p2) // == 运算符会调用"equals"方法

    println(p1.equals(42))
}