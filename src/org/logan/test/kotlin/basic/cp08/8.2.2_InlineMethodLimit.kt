package org.logan.test.kotlin.basic.cp08.ext822

/**
 * desc: 内联函数的限制 <br/>
 *
 * time: 2019/12/20 2:50 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 1，不是所有使用 lambda 的函数都可以被内联 -- 根据lambda参数使用情况而定。
//    当函数被内联的时候，作为参数的 lambda表达式的函数体会被直接替换到最终生成的代码中。
//    这将限制函数体中的对应 lambda参数 的使用。如果(lambda)参数 被调用，这样的代码能被容易地内联。
//    但如果 (lambda)参数 在某个地方被保存起来，以便后面可以继续使用，lambda表达式的代码将不能被内联。


// 2，一般来说，参数如果被直接调用或者作为参数传递给另外一个 inline 函数， 它是可以被内联的。
//    否则，编译器会禁止参数被内联并给出错误信息 “Illegal usage of inline-parameter” (非法使用内联参数)。

// 如下例：map 函数没有直接调用作为 transform 参数传递进来的函数。而是将这个函数传递给一个类的构造方法，
// 构造方法将它保存在一个属性中。为了支持这一点，作为 transform 参数传递的 lambda 需要被编译成标准的非内联的表示法，
// 即：一个实现了函数接口的医名类。如下例：
fun <T, R> Sequence<T>.map(transform: (T) -> R): Sequence<R> {
    return TransformingSequence1(this, transform)
}

class TransformingSequence1<T, R> constructor(
    private val sequence: Sequence<T>,
    private val transformer: (T) -> R
) : Sequence<R> {
    override fun iterator(): Iterator<R> = object : Iterator<R> {
        val iterator = sequence.iterator()
        override fun next(): R {
            return transformer(iterator.next())
        }

        override fun hasNext(): Boolean {
            return iterator.hasNext()
        }
    }
}

// 3，如果一个函数期望两个或更多lambda参数，可以选择只内联其中一些参数。这是有道理的，因为一个 lambda 可能会包含很多代码
//    或者以不允许内联的方式使用。 接收这样的非内联 lambda 的参数，可以用 noinline 修饰符来标记它:
inline fun foo(// 标记内联的
    inlined: () -> Unit,   // 内联
    noinline notInlined: () -> Unit // 非内联，noinline
) {

}

// 4，注意，编译器完全支持内联跨模块的函数或者第三方库定义的函数。
//    也可以在 Java 中调用绝大部分内联函数，但这些调用并不会被内联，而是被编译成普通的函数调用。

