package org.logan.test.kotlin.basic.cp05


import org.logan.test.kotlin.basic.cp05.java.ToolJobCp05.postponeComputation

/**
 * desc: 把 lambda 当作参数传递给 Java 方法 <br/>
 * 可以把lambda传给任何期望函数式接口的方法。自Kotlin 1.0起，每个lambda表达式都会被编译成一个匿名类，除非它是一个内联lambda。<br/>
 * 后续版本计划支持生成Java 8 字节码。一旦实现，编译器就可以避免为每一个lambda 表达式都生成一个独立的.class 文件。 <br/>
 *
 * time: 2019-09-19 13:53 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    /**
     * 例1：
     * 可以把lambda传给任何期望函数式接口的方法。
     **/
    postponeComputation(1000) {
        // 这里是ASM接口的实现，即：Runnable run()函数体。并且整个程序只会创建一个 Runnable的实例。
        println("Lambda方式调用")
    }

    /**
     * 例2：
     * 下面显式地创建一个实现了 Runnable的匿名对象，实现效果与上面的lambda一样。
     * 但是有点区别，就是创建实例点次数上。譬如：该例的Runnable实例创建次数是有区别的。
     **/
    postponeComputation(1000, object : Runnable {
        override fun run() {
            // 显式地声明对象时，每次调用都会创建一个新的实例
            println("object方式调用")
        }
    })


    // 例3：下面的例子与例1在性能上是完全等价的
    val runnable = Runnable { println("预先实例化runnable方式") }
    postponeComputation(1000, runnable)


    // 例4：看object方式的内存变化
    println()
    showObjectMemoryAddress()


    // 例5：被lambda捕获后，匿名对象每次调用就不会是一个对象实例了。
    handleComputation("11")
    handleComputation("22")


    /**
     *  请注意这里讨论的为 lambda创建一个匿名类，以及该类的实例的方式只对期望 函数式接口的 Java方法有效，
     *  但是对集合使用 Kotlin 扩展方法的方式并不适用。
     *  如果你把 lambda 传给了标记成 inline 的 Kotlin函数，是不会创建任何匿名类的。
     **/
}

/**
 * 如果 lambda 从包围它的作用域中捕捉了变量，每次调用就不再重用同一个实例了。
 * 这种情况下，每次调用时编译器都要创建一个新对象，其中存储着被捕捉的变量的值。
 **/
fun handleComputation(id: String) {
    // 因为id被lambda捕获，因此每次调用都会使用一个新的 Runnable实例
    postponeComputation(1000) {
        println(id) // lambda会捕获id变量
    }
}

fun showObjectMemoryAddress() {
//    for (i in 1..3) {
//        postponeComputation(1000) {
//            println("Lambda方式 1：" + this) // 1，lambda内部没有匿名对象那样的this，这个this会报错。
//        }
//    }

    for (i in 1..3) {
        postponeComputation(1000, object : Runnable {
            override fun run() {
                println("object方式调用（注意看内存地址！）：" + this) // 2，在匿名对象内，this关键字指向该对象实例
            }
        })
    }
}