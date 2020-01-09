package org.logan.test.kotlin.basic.cp09

/**
 * desc: 运行时的泛型: 类型检查和转换 <br/>
 *
 * 和 Java一样， Kotlin 的泛型在运行时也被擦除了。如：List<String> 在运行时，编译器只知道是List，但不晓得是String。
 * 你不能判断一个列表是一个包含字符串的列表，还是包含其他对象的列表，因为这些信息在运行时被擦除了。
 *
 * 这就是擦除类型信息的约束，因为类型实参没有被存储下来，你不能检查它们。
 * 擦除泛型类型信息是有好处的：应用程序使用的内存总量较小，因为要保存在内存中的类型信息更少。
 *
 * Kotlin 不允许使用没有指定类型实参的泛型类型。那么如何检查一个值是否是List，而不是set或者其他对象。
 * 可以使用特殊的星号投影语法来做这种检查:
 *      if (value is List<*>) { ... }
 *
 * 实际上，泛型类型拥有的每个类型形参都需要一个*。可以认为它就是拥有未知类型实参的泛型类型，类比于Java的List<?>
 *
 * time: 2020/1/8 4:18 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun printlnSum(c: Collection<*>) {
    // 注意：
    // 在 as 和 as? 转换中仍然可以使用一般的泛型类型。但是如果该类有正确的基础类型但类型实参可能是错误的，转换也不会失败(编译没问题)，
    // 因为在运行时转换发生的时候类型实参是未知的。因此，这样的转换会导致编译器发出“unchecked cast”(未受检转换)的警告。
    // 这仅仅是一个警告，你仍然可以继续使用这个值，如：下面的intList.sum()

    val intList = c as? List<Int> // 使用as?安全转换，这里会有警告: Unchecked cast: Collection<*> to List<Int>
    //                               因为*号可以是任何类型。
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

// 使用 is 代替 as?
fun printlnSmartSum(c: Collection<Int>) { // 范型类型从*变成了Int

    if (c is List<Int>) { // Kotlin 编译器在编译期，它已经知道相应的类型信息时，is检查是允许的。
        //                   这样就确保了 c 一定是 List<Int> 类型
        println(c.sum())
    }
}

fun main() {

    printlnSum(listOf(1, 2, 3)) //正常输出

    // printlnSum(setOf(1, 2, 3)) // IllegalArgumentException错误：set不是List 类型

    // printlnSum(listOf("a", "b", "c")) // ClassCastException错误：String不能转换成Int。
    //                                      也就是说List转换成功了，但将String转换成Int导致了异常。
    //                                      解决方案见 printlnSmartSum()

    printlnSmartSum(listOf(1, 2, 3))
}