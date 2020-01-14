package org.logan.test.kotlin.basic.cp09

/**
 * desc: 协变 - 保留子类型化关系 <br/>
 *
 * time: 2020/1/13 1:45 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */


// 一个协变类是一个泛型类(以下面 Producer<T>为例），对这种类来说，下面的描述是成立的：
// 如果 A 是 B 的子类型，那么 Producer<A> 就是 Producer<B> 的子类型。我们说子类型化被保留了。
// 例如 ，Producer<Cat> 是 Producer<Animal> 的子类型， 因为 Cat 是 Animal 的子类型。
// 在 Kotlin 中，要声明类在某个类型参数上是可以协变的，在该类型参数的名称前加上 out 关键字:
interface Producer<out T> { // 类被声明在T上的协变

    fun produce(): T
}


open class Animal {
    open fun feed() {}
}

// 将一个类的类型参数标记为协变的，在该类型实参 没有精确匹配到函数中定义的类型形参时，
// 可以让该类的值作为这些函数的实参传递，也可以作为这些函数的返回值。
class Herd<out T : Animal> { // 使用out，将 T 声明可协变的
    private val animals: List<T> = listOf()

    val size: Int get() = animals.size

    fun get(i: Int): T = animals[i] // 把 T 作为返回值使用
}

fun feedAll(animals: Herd<Animal>) {
    for (i in 0 until animals.size) {
        animals.get(i).feed()
    }
}

class Cat : Animal() { // Cat是一个Animal
    fun cleanLitter() {
        println("cat cleanLitter()")
    }
}

fun takeCareOfCate(cats: Herd<Cat>) {
    for (i in 0 until cats.size) {
        cats.get(i).cleanLitter()
        feedAll(cats) // 如果将Herd类声明的out删除，将会编译错误：推导的类型是Herd<Cat>，但期望的却是Herd<Animal>
        //               但是一旦声明为协变的，编译可以通过了。
    }
}



