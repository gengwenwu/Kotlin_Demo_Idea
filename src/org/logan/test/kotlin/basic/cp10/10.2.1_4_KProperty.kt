package org.logan.test.kotlin.basic.cp10

/**
 * desc: Kotlin反射API - KProperty <br/>
 *
 * time: 2019-09-08 14:05 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

var counter = 0


fun main(args: Array<String>) {
    val kProperty = ::counter

    kProperty.setter.call(21) // 通过反射调用setter，将21作为实参传递


    println(kProperty.getter.call()) // 使用call()调用，但是该方式不如下面的get()
    println(kProperty.get()) // 通过调用get获取属性的值，实际调用 getter


    // 只能使用反射访问定义在最外层或者类中的属性，而不能访问函数的局部变量。
    val x = 1
    // val y = ::x //无法编译通过。
}