package org.logan.test.kotlin.basic.cp04.ext432

/**
 * desc: 自动生成通用对象方法 (data修饰符) - toString()、equals()、hashCode()  <br/>
 * time: 2019-09-01 18:59 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

/*
 * 使用data修饰符，自动生成 toString()、equals()、hashCode()、copy()函数。注意：<br/>
 * 1，equals和hashCode方法会将所有在主构造方法中声明的属性纳入考虑。没有在主构造方法中声明的属性将不会加入到相等性检查和哈希值计算中去。<br/>
 * 2，虽然数据类的属性并没有要求是val，同样可以使用var，但是强烈推荐只使用只读属性，让数据类的实例不可变。 <br/>
 *    如果你想使用这样的实例作为HashMap或者类似容器的键，这会是必需的要求。不可变对象在多线程中可以更安全的使用。 <br/>
 * 3，copy()创建的是一个副本，对原始对象没有影响。 <br/>
 **/
data class Client(val name: String, val postalCode: Int)


fun main(args: Array<String>) {
    val bob = Client("Bob", 973293)
    println(bob.copy(postalCode = 382555))

}