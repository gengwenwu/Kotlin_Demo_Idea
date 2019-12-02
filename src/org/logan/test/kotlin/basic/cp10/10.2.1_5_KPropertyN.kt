package org.logan.test.kotlin.basic.cp10

/**
 * desc: KProperty 提供了类似FunctionN的功能，但只有KProperty1、KProperty2，<br/>
 * 它们都是一个泛型类,而且它们都在库代码中，非自动生成的。<br/>
 *
 * time: 2019-09-08 14:30 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    val person = Person("Alice", 29)
    val memberProperty = Person::age

    /**
     * 一个成员属性由 KProperty1 的实例表示，它拥有一个单参数的 get方法。
     * 要访问该属性的值，必须提供你需要的值所属的那个对象实例。
     **/
    println(memberProperty.get(person)) // 输出 29
    // memberProperty.get("Alice") // 这样的调用不会通过编译，因为范型，已经约定了入参一定是Person类型。

}