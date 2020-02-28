package org.logan.test.kotlin.basic.cp06

/**
 * desc: Elvis运算符: ?: <br/>
 * 它是用来代替 null 的默认值，它像猫王Elvis，因此称之为Elvis运算符。它接受两个运算符：<br/>
 * 如果第一个运算数不为null，运算结果就是第一个运算数；如果第一个运算数为 null，运算结果就是第二个运算数。
 *
 * foo ?: bar
 *      如果foo!=null，则返回foo
 *      如果foo==null，返回bar
 *
 * time: 2019-09-22 18:31 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 例1
fun foo(s: String?) {
    val t: String = s ?: "" // 如果s为nul，返回 零宽度字符串
    println(t)
}


// 例2：Elvis运算符经常和安全调用运算符一起使用
fun strLenSafe2(s: String?): Int = s?.length ?: 0


// 例3：简化 Person.countryName() 函数
fun Person.countryName2() = company?.address?.country ?: "Unknown"


// 例4：抛出一个异常
fun printShippingLabel(person: Person) {
    val address =
        person.company?.address ?: throw IllegalArgumentException("No address") // 缺少地址，抛出异常

    with(address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}


fun main(args: Array<String>) {
    println(strLenSafe2("abc"))
    println(strLenSafe2(null))


    println()
    val person = Person("Dmitry", null)
    println(person.countryName2())


    println()
    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person2 = Person("Dmitry", jetbrains)
    printShippingLabel(person2)

    println()
    printShippingLabel(Person("Alexey", null))

}