package org.logan.test.kotlin.basic.cp06

/**
 * desc: 可空的基本数据类型: Int?、 Boolean?及其他 <br/>
 * Kotlin 中的可空类型不能用 Java的基本数据类型表示，因为 null只能被存储在 Java的引用类型的变量中。
 * 这意味着任何时候只要使用了基本数据类型的可空版本，它就会编译成对应的包装类型。
 *
 * time: 2019-11-27 11:22 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
data class Person2(val name: String, val age: Int? = null) {// age是可空类型，被当作java.lang.Integer存储

    fun isOlderThan(other: Person2): Boolean? {
        // 你不能直接比较 Int?类型的两个值，因为它们之中任何一个都可能为null。
        // 相反，你必须检查两个值都不为 null。然后，编译器才允许你正常地比较它们。
        if (age == null || other.age == null) {
            return null
        }

        return age > other.age
    }

}

fun main(args: Array<String>) {
    // 泛型类是包装类型应用的另一种情况。如果你用基本数据类型作为泛型类的类型参数，那么Kotlin会使用该类型的包装形式。
    // 创建了一个 Integer包装类的列表，尽管你从来没有指定过可空类型或者用过null值，这是由Java虚拟机实现泛型的方式决定的。
    val listOfInts = listOf(1, 2)
    println("listOfInts  中的类型：${listOfInts.get(0).javaClass.name}")

    val listOfInts2 = listOf(Integer.valueOf(1), Integer.valueOf(2))
    println("listOfInts2 中的类型：${listOfInts2.get(0).javaClass.name}")
}