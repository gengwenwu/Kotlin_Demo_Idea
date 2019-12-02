package org.logan.test.kotlin.basic.cp06

/**
 * desc: 类型参数的可空性 <br/>
 * Kotlin中，所有 泛型类 和 泛型函数的类型参数 默认都是可空的。任何类型，包括可空类型在内，都可以替换类型参数。
 * 这种情况下，使用类型参数作为类型的声明 都允许为null，尽管类型参数T 并没有用问号结尾。
 *
 * time: 2019-11-26 14:46 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun <T> printHashCode(t: T) { // 虽然t未声明?，但是依旧可以为null
    println(t?.hashCode()) // 必须使用安全调用
}


// 为类型参数声明非空上界
fun <T : Any> printlnHashCode(t: T) { //现在T就不是可空的
    println(t.hashCode())
}

fun main(args: Array<String>) {
    printHashCode(null) // 在 printHashCode 调用中，类型参数 T推导出的类型是可空类型 Any?
    // printlnHashCode(null) // 编译错误，不能传null


}