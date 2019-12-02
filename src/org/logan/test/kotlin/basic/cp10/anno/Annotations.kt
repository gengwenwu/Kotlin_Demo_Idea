package org.logan.test.kotlin.basic.cp10.anno

import kotlin.reflect.KClass

/**
 * desc: Kotlin 注解声明  <br/>
 * time: 2019-09-07 14:33 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

annotation class Anno( // Kotlin使用annotation关键字声明注解
    val args1: KClass<*>, // val关键字是强制的
    val arg2: KClass<out Any>
) // Kotlin注解不能有任何实现主体


// 与Java版本的 jsonNameInJava.java 对比
annotation class JsonNameInKotlin(val name: String, val name2: String)
