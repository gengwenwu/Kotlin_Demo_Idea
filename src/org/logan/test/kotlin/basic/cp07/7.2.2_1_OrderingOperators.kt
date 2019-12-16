package org.logan.test.kotlin.basic.cp07

/**
 * desc: 排序运算符 : Kotlin支持Java的Comparable接口 <br/>
 * 但是接口中定义的compareTo()可以按约定调用，比较运算符(<，>，<=和>=)的使用将被转换为compareTo()，
 * 如：a >= b 实际调用的是：a.compareTo(b) >= 0 ，两个对象的比较被转换为 compareTo() 调用，然后结果与零比较。
 *
 * Comparable的compareTo()在基类中使用了operator修饰符，因此实现类无须再重复。
 *
 *
 * time: 2019/12/12 11:14 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Person(
    val firstName: String, val lastName: String
) : Comparable<Person> {


    override fun compareTo(other: Person): Int {// 实现比较接口
        /*
         *要注意如何使用 Kotlin 标准库中的 compareValuesBy() 来简洁地实现 compareTo()。
         * 这个函数接收用来计算比较值的一系列回调，按顺序依次调用回调方法，两两一组分别做比较，井返回结果。
         * 如果值不同，则返回比较结果；如果它们相同，则继续调用下一个；如果没有更多回调来调用，则返回 0。
         * 这些回调函数可以像 lambda 一样传递，或者像这里做的一样，作为属性引用传递。
         *
         * 注意，尽管自己直接实现字段的比较会运行得更快一点 ，然而这样会包含更多的代码。
         * 一般情况下，更推荐使用简洁的写法，不用过早地担心性能问题，除非你知道这个实现将会被频繁调用。
         */
        return compareValuesBy(
            this, other, // 按顺序调用给定的方法，并比较它们的值
            Person::lastName, Person::firstName
        )
    }
}

fun main() {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Johnson")
    println(p1 < p2) //因为Person实现了Comparable接口，所以可以使用类似<比较两个对象，实际调用compareTo()函数


    // 所有 Java中实现了Comparable接口的类，都可以在 Kotlin中使用简洁的运算符语法，不用再增加扩展函数:
    println("abc" <= "abc")
}