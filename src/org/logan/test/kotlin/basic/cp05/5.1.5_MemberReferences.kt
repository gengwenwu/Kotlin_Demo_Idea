package org.logan.test.kotlin.basic.cp05

/**
 * desc: 成员引用 - 为直接调用方法或访问属性的函数提供了一种简短的语法。<br/>
 * 基本语法：Class::member，双冒号将类名与引用的成员（方法或属性）分隔出来 <br/>
 *
 * time: 2019-09-06 11:50 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    // 1，成员引用表达式
    val getAge = Person::age // 这个表达式叫做成员引用
    val getAge2 = { person: Person -> person.age } // 与上一句代码效果一样


    /**
     * 2，成员引用 拥有和调用那个函数的lambda同样的类型，所以可以互换的使用这两者。
     * 注意：不管你引用函数还是属性，不能在成员引用后面加一对圆括号。譬如：
     * people.maxBy(Person::age()) // age后面加()是不正确的。
     *
     **/
    val people = listOf(Person("Alice", 20), Person("Bob", 30))
    people.maxBy(Person::age) // 成员引用
    people.maxBy { it.age } // lambda方式。


    // 3
    run(::salute) // 可以直接引用 顶层函数，注意，这里省略了类名。外层是()
    run { salute() } // lambda外层是{}


    /**
     * 4，提供一个成员引用非常方便，但是相反的是，委托给一个接收多个参数的函数却代码冗余的多。
     **/
    // action这个lambda委托为sendEmail函数
    val action = { person: Person, message: String ->
        sendEmail(person, message)
    }

    // 相反，使用成员引用就简单的多
    val nextAction = ::sendEmail


    // 5，可以使用"构造函数引用"来保存或者延迟创建类实例的动作
    val createPerson = ::Person // 创建"Person"类实例的动作被保存到createPerson中
    val p = createPerson("Alice", 29)  // 这里才是真正创建对象的地方
    println(p)


    // 6，方法引用同样适用于扩展函数
    val predicate = Person::isAdult


    // 7，Kotlin 不同版本，针对方法引用的一些区别
    val p1 = Person("Dmitry", 34)
    val personAgeFunction = Person::age
    println(personAgeFunction(p1)) // 在Kotlin 1.0，当引用类的方法或属性时，在调用这个引用时，要求提供那个类的实例。如：这里的入参p1

    val dmitrysAgeFunction = p1::age
    println(dmitrysAgeFunction()) // Kotlin 1.1 支持绑定方法引用。这将允许使用方法引用语法来捕捉特定对象实例中的方法引用。

}


fun salute() = println("Salute!")

fun sendEmail(person: Person, message: String) {
    println("$person send $message")
}

fun Person.isAdult() = age >= 21
