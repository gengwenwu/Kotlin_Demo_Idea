package org.logan.test.kotlin.basic.cp09

/**
 * desc: 使用点变型：在类型出现的地方指定变型，使用点变型有助于放宽可接收的类型的范围。 <br/>
 *
 * 在类声明的时候就能够指定变型修饰符是很方便的，因为这些修饰符会应用到所有类被使用的地方。这被称作 声明点变型。
 * Java的通配符类型 (? extends 和 ? super)，每一次使用带类型参数的类型的时候，
 * 还可以指定这个类型参数是否可以用它的 子类型或者超类型替换。这叫作 使用点变型。
 * // Java代码
 * public interface Stream<T> {
 *     <R> Stream<R> map(Function<? super T, ? extends R> mapper);
 * }
 *
 * Kotlin 也支持使用点变型，允许在类型参数出现的具体位置指定变型，即使在类型声明时它不能被声明成协变或逆变的
 *
 * 注意：Kotlin 使用点变型直接对应 Java 的限界通配符。
 * Kotlin 中的 MutableList<out T> 和 Java 中的 MutableList<? extends T> 是一个意思。
 * in 投影的 MutableList<in T> 对应到 Java的 MutableList<? super T>。
 *
 * time: 2020/3/10 2:54 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun <T> copyDataAny(
    source: MutableList<T>,
    destination: MutableList<T>
) {
    for (item in source) {
        destination.add(item)
    }
}

fun <T : R, R> copyData( // 修改点：使用两个范型，其中 T 继承 R
    source: MutableList<T>,
    destination: MutableList<R>
) {
    for (item in source) {
        destination.add(item)
    }
}

// Kotlin 提供了一种更优雅的表达方式1：使用out
fun <T> copyDataOut(
    source: MutableList<out T>, // 修改点：使用out：参数source只能使用T在out位置上的函数，允许source元素类型是destination元素类型的子类型
    destination: MutableList<T>

    // 可以为类型声明中，类型参数任意的用法指定变型修饰符(in、out)，这些用法包括：形参类型(就像 9.3.3_1_CovarianceOut.kt)、
    // 局部变量类型、函数返回类型，等等。这里发生的一切被称作 类型投影：我们说 source 不是一个常规的 MutableList，
    // 而是一个投影(受限)的 MutableList。
    // 只能调用返回类型是泛型类型参数的那些方法，或者严格地讲，只在 out 位置使用它的方法。
    // 编译器禁止调用使用类型参数做实参 (类型)的那些方法(在扫位置使用类型参数):
    // val list: MutableList<out Number> = ...
    // list.add(42) // 编译报错
    // Error：out projected type 'MutableList<out Number>' prohibits the use of 'fun add(element: E): Boolean'

    // 不要为使用投影类型后不能调用某些方法而吃惊。如果需要调用那些方法，你要用的是常规类型而不是投影。
    // 这可能要求你声明第二个类型参数，它依赖的是原本要进行投影的类型，就像上面的copyData()那样。

    // 当然，实现 copyDataOut() 的正确方式应该是使用 List<T> 作为 source 实参的类型，
    // 因为我们只用了声明在 List 中的方法，并没用到 MutableList 中的方法，
    // 而且 List 类型参数的变型在声明时就指定了 (指定了out，看List源码就知道了)。
    // 但这个例子对展示这个概念依然十分重要，尤其是要记住大多数的类并没有像 List 和 MutableList 这样分开的两个接口，
    // 一个是协变的读取接口，另一个是不变型的读取/写入接口。

    // 如果类型参数已经有 out 变型，再次指定 out 投影没有任何意义。就像 List<out T>这样。
    // 它和 List<T> 是一个意思，因为 List 已经声明成了 class List<out T> 。
    // Kotlin 编译器会发出警告，表明这样投影是多余的。
) {
    for (item in source) {
        destination.add(item)
    }
}

// Kotlin 提供了一种更优雅的表达方式2：使用in
fun <T> copyDataIn(
    source: MutableList<T>,
    destination: MutableList<in T> // 修改点：使用in：允许destination元素类型是source元素类型的超类型

    // 与copyDataOut()同理，可以对类型参数的用法使用 in 修饰符，来表明在这个特定的地方，
    // 相应的值担当的是消费者，而且类型参数可以使用它的任意子类型替换。
    // 当前 copyDataIn() 展示了如何使用 in 投影来重写 copyDataOut() 中的代码。
) {
    for (item in source) {
        destination.add(item)
    }
}


fun main() {
    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()

    // 编译错误
    // copyDataAny(ints, anyItems)

    copyData(ints, anyItems) // int是Any的子类
    println(anyItems)

    copyDataOut(ints, anyItems)
    println(anyItems)

    copyDataIn(ints, anyItems)
    println(anyItems)

}