package org.logan.test.kotlin.basic.cp04

/**
 * desc: 手动编写通用对象方法 - toString()、equals()、hashCode() <br/>
 * time: 2019-09-01 18:43 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Client(val name: String, val postalCode: Int) {

    override fun toString(): String {
        return "Client(name=$name, postalCode=$postalCode)"
    }

    // “Any”是java.lang.Object的模拟。Kotlin中所有类的父类。可空类型“Any?”意味着“other”是可以为空的。
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client) { // Kotlin中的is检查是Java中instanceOf的模拟
            return false
        }

        // 检查对应的属性是否相等
        return name == other.name && postalCode == other.postalCode
    }

    // hashCode契约：如果两个对象相等，它们必须有着相同的hash值。首先比较它们的hash值，然后只有当它们相等时才会去比较真正的值。
    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

}

fun main(args: Array<String>) {
    val client1 = Client("Alice", 342562)
    val client2 = Client("Alice", 342562)
    // 在Kotlin中，==检查对象是否相等，而不是比较引用。引用使用===判断
    println(client1 == client2)


    val processed = hashSetOf(Client("Alice", 342562))
    println(processed.contains(Client("Alice", 342562))) // 必须遵守hashCode契约，如果返回true，必须重写hashCode

}