package org.logan.test.kotlin.basic.cp09.ext9332

import org.logan.test.kotlin.basic.cp09.Animal

/**
 * desc: 协变 -- in 和 out <br/>
 *
 * 不能把任何类都变成协变的:这样不安全。
 * 让类在某个类型参数变为协变，限制了该类中对该类型参数使用的可能性。
 *
 * 要保证类型安全，它只能用在所谓的 out位置，意味着这个类只能生产类型 T 的值而不能消费它们。
 *
 * time: 2020/1/13 2:16 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */


// 1，在类成员的声明中类型参数的使用可以分为 in 位置和 out位置 。
interface Transformer<T> { // <in T> 或者 <out T>
    // 类的类型参数前的 out 关键字要求所有使用 T 的方法只能把 T 放在 out 位置(返回值)，而不能把 T 放在in位置(入参)。
    // 这个关键宇约束了使用 T 的可能性，这保证了对应子类型关系的安全性。
    // 譬如：9.3.3_1_CovarianceOut.kt中 Herd的get()函数返回值。那是一个 out 位置，可以安全地把类声明成协变的。
    // 如果 Herd<Animal> 类的get方法返回的是Cat，任何调用该方法的代码都可以正常工作， 因为 Cat 是 Animal 的子类型。

    // 重申一下，类型参数 T 上的关键宇 out 有两层含义:
    // (1)，子类型化会被保留 ( Herd<Cat> 是 Herd <Animal> 的子类型)
    // (2)，T 只能用在out位置


    // 下面第一个T是消费类型的T（in的位置），第二个T是生产类型的T（out位置）。
    fun transform(t: T): T

}


// 2，Kotlin List接口，它是只读的，out标示了它是支持协变。
interface List<out T> : Collection<T> {

    operator fun get(index: Int): T // 返回T，它在out位置上

    fun subList(fromIndex: Int, toIndex: Int): List<T> // 类型形参不仅可以直接当作参数类型或者返回类型使用，
    //                                                    还可以当作另一个类型的类型实参，如这里的 List<T>，
    //                                                    这里的T也是out位置
}


// 3，Kotlin MutableList接口，支持读写，但不能把 MutableList<T> 在它的类型参数上声明成协变的。
// 因为它既含有接收类型为 T 的值作为参数的方法，也含有返回这种值的方法（ T 同时出现在 in 和 out 位置上）
// 编译器强制实施了这种限制。
interface MutableList<T> // 不能声明协变
    : List<T>, MutableCollection<T> {

    override fun add(element: T): Boolean // T用在in的位置上

}

// 4，构造方法的参数既不在 in 位置，也不在 out 位置。
// 即使类型参数声明成了 out，仍然可以在构造方法参数的声明中使用它，如下：
class Herd<out T : Animal>(vararg animals: T)


// 5，如果在构造方法的参数上使用了关键字 val 和 var，就会自动声明一个 getter 和一个 setter (如果属性是可变的)。
// 因此，对只读属性来说，类型参数用在了 out 位置 ，而可变属性在 out 位置和 in 位置都使用了它:
class Herd2<T : Animal>( // 这个 T 不能支持协变
    var leadAnimal: T, vararg animals: T // 因为类包含属性 leadAnimal 的 setter，它在 in 位置用到了 T。
)


// 6，位置规则只覆盖了类外部可见的 (public、 protected 和 internal) API。
// 私有方法的参数既不在 in位置也不在 out位置。变型规则只会防止外部使用者对类的误用，但不会对类自己的实现起作用:
class Herd3<out T : Animal>(// 支持协变
    private var leadAnimal: T, // leadAnimal 的 T 不在in和out位置，因为它是private的，所有setter、getter 也不会有问题。
    vararg animals: T
)
