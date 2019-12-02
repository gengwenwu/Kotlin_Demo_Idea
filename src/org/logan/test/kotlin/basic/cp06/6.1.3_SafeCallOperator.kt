package org.logan.test.kotlin.basic.cp06



/**
 * desc: Kotlin安全调用运算符: ?. <br/>
 * 它允许你把一次 null 检查和一次方法调用合并成一个操作。例如：<br/>
 * 表达式 s?.toUpperCase() 等同于这种写法: if (s != null) s.toUpperCase() else null <br/>
 *
 * foo?.bar()
 *      如果foo!=null，调用foo.bar()函数。
 *      如果foo==null，返回null。
 *
 * time: 2019-09-22 18:13 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 例1：使用安全操作符
fun printAllCaps(s: String?) {
    // s如果非空，toUpperCase()调用会被正常地执行。如果s为null，整个表达式返回null
    val allCaps: String? = s?.toUpperCase() // allCaps可能为null
    println(allCaps)
}


// 例2：安全调用可空属性
class Employee(val name: String, val manager: Employee?) // manager属性可以为null

fun managerName(employee: Employee): String? = employee.manager?.name // 安全调用manager name属性


// 例3：链接多个安全调用
class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    val country = this.company?.address?.country // 多个安全符一起调用
    return if (country != null) country else "Unknown"
}


fun main(args: Array<String>) {
    printAllCaps("abc")
    printAllCaps(null)


    println()
    val ceo = Employee("Alice", null)
    val developer = Employee("Bob Smith", ceo)
    println(managerName(ceo))
    println(managerName(developer))


    println()
    val person = Person("Dmitry", null)
    println(person.countryName())
}