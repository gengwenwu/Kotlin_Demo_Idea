package org.logan.test.kotlin.basic.cp10

/**
 * desc: Kotlin - FunctionN 接口 <br/>
 *
 * FunctionN中的N代表了不同数量参数的函数。每一个FunctionN类型都继承了 Function，并加上一个额外的 invoke()。<br/>
 * 例如：Function2 声明了 operator fun invoke(p1: P1, p2: P2): R, 其中P1和P2代表着函数的参数类型，而R代表着函数的返回类型。<br/>
 * 搜索：Function2，找到源文件Functions.kt文件。
 *
 * FunctionN 又称之为：合成的编译器生成类型，你不会在包 kotlin.reflect 中找到它们的声明。<br/>
 * 这意味着你可以使用任意数量参数的函数接口(其实最多22个参数)。合成类型的方式减小了kotlin-reflect.jar的尺寸，同时避免了对函数类型参数数量的人为限制。<br/>
 *
 * time: 2019-09-08 11:33 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun sum(x: Int, y: Int) = x + y


fun main(args: Array<String>) {

    val function2: Function2<Int, Int, Int> = ::sum

    println(function2.invoke(1, 2) + function2(3, 4))


    /**
     * 下面代码，编译都无法通过。与kFunction Call()比较。<br/>
     * 如果你有一个具体类型的 Function，它的形参类型和返回类型是确定的，那么优先使用这个具体类型的 invoke()。<br/>
     * call() 是对所有类型都有效的通用手段，但是它不提供类型安全性。<br/>
     **/
    // function2(1)

}