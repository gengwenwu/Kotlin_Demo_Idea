// 任何应用到 file 目标的注解都必须放在文件的顶层，放在 package 指令之前。
@file:JvmName("10_1_1_AnnotationTarget")

package org.logan.test.kotlin.basic.cp10

import org.junit.Rule
import org.junit.rules.TemporaryFolder
import org.logan.test.kotlin.basic.cp10.java.Ann

/**
 * desc: Kotlin注解目标 <br/>
 * Kotlin源代码中的单个声明会对应成多个Java声明，而且它们每个都能携带注解。<br/>
 * 如：一个Kotlin属性就对应了一个Java字段、一个getter，setter等。说明这些元素中哪些需要注解十分必要。<br/>
 * 点目标声明被用来说明要需要注解的元素，点目标语法：将@符号和注解名称之间，并用冒号和注解名称隔开。如：@get:Rule <br/>
 *
 * time: 2019-09-07 15:14 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class HashTempFolder {

    @get:Rule // 将 @Rule 注解应用于属性 getter
    val tempFolder = TemporaryFolder()
}


class Example(
    @field:Ann val foo: String,  // 标注 Java 字段
    @get:Ann val bar: Int, // 标注 Java getter
    @param:Ann val p1: String  // 标注 Java 构造函数参数
)

fun test(list: List<*>) {

    @Suppress("UNCHECKED_CAST") // Kotlin允许你对任意的表达式应用注解，而不仅仅是类和函数的声明及类型(和Java不一样)。
    val strings = list as List<String>
}

/*
 Kotlin支持的使用点目标的完整列表如下：

 property - Java 的注解不能应用这种使用点目标。
 field - 为属性生成的字段。
 get - 属性的 getter。
 set - 属性的setter。
 receiver - 扩展函数或者扩展属性的接收者参数。
 param - 构造方法的参数。
 setparam - 属性setter的参数。
 delegate - 为委托属性存储委托实例的字段 。
 file - 包含在文件中声明的顶层函数和属性的类。
* */
