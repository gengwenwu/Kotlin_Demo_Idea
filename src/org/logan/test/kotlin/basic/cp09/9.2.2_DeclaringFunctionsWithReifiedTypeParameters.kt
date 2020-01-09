package org.logan.test.kotlin.basic.cp09

/**
 * desc: 声明 带实化类型参数 的函数 <br/>
 *       泛型函数的类型实参也是在运行时会被擦除的。
 *
 * time: 2020/1/9 10:47 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 下面函数编译错误：Error: Cannot check for instance of erased type: T
// fun <T> isA(value: Any) = value is T

// 只有一种例外可以避免类型擦除的限制：内联函数。
// 内联函数的类型形参能够被实化(reified)，这样就可以在运行时引用实际的类型实参。
inline fun <reified T> isA(value: Any) = value is T // 可以编译通过了

// 注意， 带 reified 类型参数的 inline 函数不能在Java代码中调用。
// 普通的内联函数可以像常规函数那样在 Java 中调用 -- 它们可以被调用而不能被内联。
// 带实化类型参数的函数需要额外的处理，来把类型实参的值替换到字节码中，所以它们必须永远是内联的。
// 这样它们不可能用 Java 那样普通的方式调用。

fun main() {
    println(isA<String>("abc"))
    println(isA<String>(123))


    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>()) // 通过指定<String>作为函数的类型实参，可以过滤出字符串元素

}

// filterIsInstance 简版实现
// 一个内联函数可以有多个实化类型参数，也可以同时拥有非实化类型参数和实化类型参数。

// 注意：在第8章节中，把函数标记成内联只有在一种情况下有性能优势，
// 即：函数拥有函数类型的形参并且其对应的实参 一一 lambda和函数一起被内联的时候。
// 但下面的 filterIsInstance() 虽然被标记成inline，而它并不期望 lambda作为实参。这里这样做是为了能够使用实化类型参数。

inline fun <reified T> //  “reified” 声明了类型参数不会在运行时被擦除
        Iterable<*>.filterIsInstance(): List<T> {

    val des = mutableListOf<T>()
    for (ele in this) {
        if (ele is T) { // 检查元素是不是指定类型实参的类的实例
            des.add(ele)
        }
    }

    return des
}





