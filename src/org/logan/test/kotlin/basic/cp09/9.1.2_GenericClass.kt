package org.logan.test.kotlin.basic.cp09

/**
 * desc: Kotlin泛型类 <br/>
 *
 * time: 2020/1/7 1:41 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 和Java一样， Kotlin通过在类名称后加上一对尖括号，井把类型参数放在尖括号内来声明泛型类及泛型接口。
// 一旦声明之后，就可以在类的主体内像其他类型一样使用类型参数。我们来看看标准 Java接口 List 如何使用 Kotlin来声明。
// 这里省去了大部分的方法定义，让例子变得简单 :
/**

 interface List<T> {
    operator fun get(index: Int): T
 }

 class StringList : List<String> {
    override fun get(index: Int): String {
        return ""
    }
 }

 class ArrayList<T> : List<T> {
    override fun get(index: Int): T {

    }
 }

 */