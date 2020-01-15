package org.logan.test.kotlin.basic.cp09

/**
 * desc: 逆变：反转子类型化关系 <br/>
 *
 * 一个逆变的类是这样的一个泛型类(我们以 Consumer<T>为例)，对于这种类，下面的描述是成立的:
 * 如果 B 是 A 的子类型，那么 Consumer<A>就是 Consumer<B>的子类型。
 * 类型参数 A 和 B 交换了位置，所以说子类型化被反转了。例如，Consumer<Animal> 就是 Consumer<Cat> 的子类型。
 *
 * 逆变可以被看成是协变的镜像：对一个逆变类来说，它的子类型化关系与用作类型实参的类的子类型化关系是相反的。
 *
 * time: 2020/1/14 11:26 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
interface Comparator<in T> { // 使用 in 关键字
    //                          in 的意思是，对应类型的值是传递进来给这个类的方法的，并且被这些方法消费。
    //                          和协变的情况类似，约束类型参数的使用将导致特定的子类型化关系。
    //                          在类型参数 T 上的 in 关键字意味着子类型化被反转了，而且 T 只能用在 in 位置。

    fun compare(e1: T, e2: T): Int // 入参的 T 是消费类型，这说明 T 只在 in 位置使用，因此它的声明之前用了in关键宇。
}


// 一个类可以在一个类型参数上协变，同时在另外一个类型参数上逆变。Function 接口就是一个经典的例子。
interface Function1<in P, out R> { // 用 in 标记的 p (参数类型) 只用在 in 位置， 而用 out 标记的 R (返回类型) 只用在 out 位置。
//                                    这意味着对这个函数类型的第一个类型参数来说，子类型化反转了，而对于第二个类型参数来说，子类型化保留了 。

    // Kotlin 的表示法 (P) -> R 是表达 Function<P, R>的另一种更具可读性的形式。
    operator fun invoke(p: P): R
}

fun enumerateCats(f: (Cat) -> Number) {
    // do something
}

fun Animal.getIndex(): Int = 3


fun main() {
    // 可以用任意对象的比较器比较具体对象
    val anyComparator = Comparator<Any> { e1, e2 ->
        e1.hashCode() - e2.hashCode()
    }

    val strings: List<String> = listOf("BB", "CC", "aA", "Dd")
    strings.sortedWith(anyComparator) // 比较字符串


    // 在Kotlin中这段代码是合法的，因为Animal是Cat的超类型，而Int是Number的子类型。
    // 函数 (P)  -> Int R 在它的参数类型上逆变，而在返回类型上协变。
    enumerateCats(Animal::getIndex) // TODO 待理解

}


