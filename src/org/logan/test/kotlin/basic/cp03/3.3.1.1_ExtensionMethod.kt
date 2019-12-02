package org.logan.test.kotlin.basic.cp03

/**
 * desc: Kotlin扩展函数：为某种类型添加新的api函数。<br/>
 * 扩展函数实质是静态函数，该性质也决定了它不能被子类重写。<br/>
 * 在扩展函数中，可以直接访问被扩展的类的其它方法和属性，就好像是在这个类自己的方法中访问它们一样。 <br/>
 * -
 * 注意，扩展函数并不允许你打破Java的封装性。与类内部定义的方法不同的是，扩展函数不能访问私有或受保护的成员。 <br/>
 * 在扩展函数的内部，可以在接收者上调用该类的任意方法，即：无论成员函数还是扩展函数(不能是private、protected)。 <br/>
 * time: 2019-08-26 15:50 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 为String扩展一个名为lastChar()函数。
// 下面的String是接收者类型，this是接收者对象
fun String.lastChar(): Char = this.get(this.length - 1)

// 接受者对象成员可以不用this来访问
fun String.lastChar2(): Char = get(length - 1)


fun main(args: Array<String>) {
    // String就是接收者类型，而“Kotlin”就是接收者对象。
    println("Kotlin".lastChar())
}