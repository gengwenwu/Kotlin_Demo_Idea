package org.logan.test.kotlin.basic.cp10


import org.logan.test.kotlin.basic.cp10.anno.JsonNameInKotlin
import org.logan.test.kotlin.basic.cp10.java.JsonNameInJava

/**
 * desc: Java注解拥有一个叫作 value 的方法，而 Kotlin注解拥有一个name属性。
 *
 * time: 2019-09-07 18:54 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 1，Java中value方法很特殊：当你应用一个注解时，你需要提供 value以外所有指定特性显式名称。
@JsonNameInJava("", value2 = "")
class AnnotationTest2

/**
 * 2，Kotlin中应用注解就是常规的构造方法调用。 <br/>
 * 可以使用命名实参语法让实参的名称变成显式的，或者可以省略掉这些实参的名称。 <br/>
 **/
@JsonNameInKotlin("value", "")
class AnnotationTest3

@JsonNameInKotlin("value", name2 = "")
class AnnotationTest4

@JsonNameInKotlin(name = "value", name2 = "")
class AnnotationTest5
