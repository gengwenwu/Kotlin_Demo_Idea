package org.logan.test.kotlin.basic.cp10

import org.logan.test.kotlin.basic.cp10.anno.Anno
import org.logan.test.kotlin.basic.cp10.java.AnnWithArrayMethod
import org.logan.test.kotlin.basic.cp10.java.AnnWithArrayValue

/**
 * desc: 注解只能拥有类型参数: 基本数据类型、字符串、枚举、类引用(如：Foo::class)、其它的注解类，以及前面这些类型的数组。<br/>
 * 指定注解实参的语法与 Java有些微小的差别。 <br/>
 * time: 2019-09-07 14:35 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 1，类作为注解的实参
@Anno(String::class, Int::class)
class MyClass


// 2，注解作为其它注解的实参数，需要去掉@前缀，如：ReplaceWith
@Deprecated("", ReplaceWith("removeAt(index)"))
fun remove2(index: Int) {

}


// 3，数组作为注解的实参 - value成员
@AnnWithArrayValue("Alice", "Bob", "Lisa")
class B


// 4，数组作为注解的实参 - 非value成员, Kotlin 1.2+ 写法
@AnnWithArrayMethod(names = ["Alice", "Bob", "Lisa"])
class C

// 数组作为注解的实参 - 非value成员, Kotlin旧版本写法
@AnnWithArrayMethod(names = arrayOf("Alice", "Bob", "Lisa"))
class D




