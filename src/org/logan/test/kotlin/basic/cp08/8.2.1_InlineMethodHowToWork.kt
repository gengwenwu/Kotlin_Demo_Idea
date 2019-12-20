package org.logan.test.kotlin.basic.cp08.ext821

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock


/**
 * desc: 内联函数如何运作 <br/>
 *
 * 如果使用 inline 修饰符标记一个函数，在函数被使用的时候编译器并不会生成函数调用的代码，
 * 而是使用函数实现的真实代码替换每一次的函数调用。
 *
 * 内联函数解决lambda性能问题，即：非内联函数，在使用lambda的时候，编译器会生成匿名类处理。
 *
 * time: 2019/12/20 2:06 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 1, 将 synchronized 函数声明为 inline，所以每次调用它所生成的代码跟 Java 的 synchronized 语句是一样的。
inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()

    try {
        return action()
    } finally {
        lock.unlock()
    }
}

fun main() {
    val l = ReentrantLock()

    // 调用这个函数的语法跟 Java 中使用 synchronized 语句完全一样。
    // 区别在于 Java 的 synchronized 语句可以用于任何对象，而这个函数则要求传入一个 Lock 实例。
    synchronized(l) {

    }
}

// 2, 对比
fun foo(l: Lock) {
    println("Before sync")

    // 下面的 synchronized() 和 lambda表达式的实现都会被内联，
    // 由 lambda 生成的字节码成为了函数调用者定义的一部分，而不是被包含在一个实现了函数接口的匿名类中。
    // 可以将上面synchronized函数关键字inline去掉，对比编译器生成foo()的相关源码情况，就清楚区别了。
    synchronized(l) {
        println("Action") // 被内联的 lambda体代码
    }

    println("After sync")
}


// 3，在调用内联函数的时候，也可以传递函数类型的变量作为参数:
// 在这种情况下，lambda 的代码在内联函数被调用点是不可用的，因此并不会被内联。只有 synchronized 的函数体被内联了，
// lambda才会被正常调用。注意看生成的字节码代码，对比上面的foo()。
class LockOwner(val lock: Lock) {
    fun runUnderLock(body: () -> Unit) {
        synchronized(lock, body) // 传递一个函数类型的的变量作为参数(body)，而不是一个lambda.
    }
}

// 如果在两个不同的位置使用同一个内联函数，但是用的是不同的lambda， 那么内联函数会在每一个被调用的位置被分别内联。
// 内联函数的代码会被拷贝到使用它的两个不同位置，并把不同的 lambda替换到其中。



