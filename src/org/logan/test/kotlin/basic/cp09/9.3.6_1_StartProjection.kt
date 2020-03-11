package org.logan.test.kotlin.basic.cp09

import java.util.*

/**
 * desc: 星号投影: 使用*代替类型参数 <br/>
 * time: 2020/3/11 10:59 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    val list: MutableList<Any?> = mutableListOf('a', 1, "qwe")
    val chars = mutableListOf('a', 'b', 'c')
    val unknownElements: MutableList<*> = if (Random().nextBoolean()) list else chars // 范型*

    // 编译报错，编译器调用这个方法
    // unknownElements.add(42)
    // Error: Out projected type ’MutableList<*>’ prohibits use of 'fun add(element: E): Boolean'

    // 读取元素是安全的
    println(unknownElements.first())

    // 上例解释：
    // 注意：MutableList<*> 和 MutableList<Any?> 不一样 (这里非常重要的是 MutableList<T> 在 T 上是不变型的)。
    // MutableList<Any?> 是可以包含任意类型的元素。而另一方面， MutableList<*> 是包含某种特定类型元素的列表，
    // 但是只是不知道具体是哪个类型。
    // MutableList<*>列表被创建成一个包含某种特定类型元素的列表，比如 String (你无法创建一个 ArrayList<*>)，
    // 而且创建它的代码期望只包含那种类型的元素。因为不知道是哪个类型，你不能向列表中写入任何东西，
    // 因为你写入的任何值都可能会违反调用代码的期望。但是从列表中读取元素是可行的，因为你心里有数，
    // 所有的存储在列表中的值都能匹配所有 Kotlin 类型的超类型 Any?。

    // 为什么编译器会把 MutableList<*> 当成 out 投影的类型？在这个例子的上下文中，
    // MutableList<*> 投影成了 MutableList<out Any?>: 当你没有任何元素类型信息的时候，
    // 读取Any?类型的元素仍然是安全的，但是向列表中写入元素是不安全的。
    // 谈到 Java 通配符， Kotlin 的 MyType<*> 对应于 Java 的 MyType<?>。

    // 注意：
    // 对像 Consumer<in T> 这样的逆变类型参数来说，星号投影等价于 <in Nothing>。
    // 实际上，在这种星号投影中无法调用用任何签名中有 T 的方法。如果类型参数是逆变的，它就只能表现为一个消费者，
    // 而且，我们之前讨论过，你不知道它可以消费的到底是什么。因此，不能让它消费任何东西。
    // 如有感兴趣，可查看 https://kotlinlang.org/docs/reference/generics.html#star-projections

}