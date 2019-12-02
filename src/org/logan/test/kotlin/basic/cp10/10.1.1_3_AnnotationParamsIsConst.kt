package org.logan.test.kotlin.basic.cp10

import org.junit.Test


/**
 * desc: 注解实参需要在编译期就是己知的，所以不能引用任意的属性作为实参。 <br/>
 * 要把属性当作注解实参使用，你需要用 const修饰符标记它。
 *
 * time: 2019-09-07 14:18 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

const val TEST_TIMEOUT = 100L

@Test(timeout = TEST_TIMEOUT)
fun testMethod() {

}

/**
 * 用 const 标注的属性可以声明在一个文件的顶层或者一个object之中，
 * 而且必须初始化为基本数据类型或者 String 类型的值。
 **/
// const val person: Person = Person("Alice", 29);

