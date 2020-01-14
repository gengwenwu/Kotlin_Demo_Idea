package org.logan.test.kotlin.basic.cp09

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


// 在类成员的声明中类型参数的使用可以分为 in 位置和 out位置 。
interface Transformer<T> { // <in T> 或者 <out T>
    // 类的类型参数前的 out 关键字要求所有使用 T 的方法只能把 T 放在 out 位置(返回值)，而不能放在in位置(入参)。
    // 这个关键宇约束了使用 T 的可能性，这保证了对应子类型关系的安全性。
    // 譬如：9.3.3_1_CovarianceOut.kt中 Herd的get()函数返回值。那是一个 out 位置，可以安全地把类声明成协变的。
    // 如果 Herd<Animal> 类的get方法返回的是Cat，任何调用该方法的代码都可以正常工作， 因为 Cat 是 Animal 的子类型。

    // 重申一下，类型参数 T 上的关键宇 out 有两层含义:
    // (1)，子类型化会被保留 ( Herd<Cat> 是 Herd <Animal> 的子类型)
    // (2)，T 只能用在out位置


    // 下面第一个T是消费类型的T（in的位置），第二个T是生产类型的T（out位置）。
    fun transform(t: T): T


}