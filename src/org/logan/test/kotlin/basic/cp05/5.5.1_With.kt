package org.logan.test.kotlin.basic.cp05

/**
 * desc: Kotlin lambda的独特功能 -> 在lambda函数体内可以调用一个对象的不同方法，而且无须借助任何额外限定符。<br/>
 * 这样的 lambda 叫作 "带接收者的lambda"。譬如：with()，对同一个对象执行多次操作，而不需要反复把对象的名称写出来。 <br/>
 * with() 把它的第一个参数转换成作为第二个参数传给它的lambda的接收者。<br/>
 * with 返回的值是执行 lambda 代码的结果，该结果就是 lambda 中的最后一个表达式(的值)。
 * -
 * 带接收者的lambda和 扩展函数 <br/>
 * 在扩展函数体内部，this指向了这个函数扩展的那个类型的实例，而且也可以被省略掉，让你直接访问接收者的成员。 <br/>
 * 注意一个扩展函数某种意义上来说就是带接收者的函数。可以做下面的类比： <br/>
 * 1，普通函数：普通的lambda。 2，扩展函数：带接收者的lambda <br/>

 * time: 2019-09-22 09:24 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

/* 1，Java思维实现打印字母表 */
fun alphabet(): String {
    val result = StringBuilder() // 问题是：重复的使用 result. 调用StringBuilder中的方法

    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet")
    return result.toString()
}

/* 2，使用Kotlin with() 打印字母表 */
fun alphabet2(): String {
    val stringBuilder = StringBuilder()

    // with中指定了接收者是StringBuilder。
    return with(stringBuilder) {
        for (letter in 'A'..'Z') {
            this.append(letter) // 显示的this调用接收者值的方法
        }
        append("\nNow I know the alphabet") //省略this也可以调用
        this.toString()
    }
}

/* 3，使用表达式函数语法重写 */
fun alphabet3() = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know the alphabet")
}

/**
 * 方法名称冲突
 * 如果当作参数传给 with 的对象已经有同样签名的方法，该方法的名称和正在使用 with 的类中的方法一样。
 * 可以给 this 引用加上显式的标签来表明你要调用的是哪个方法。
 **/
class OuterClass {

    override fun toString(): String {
        return "Hello World!"
    }

    fun alphabet4() = with(StringBuilder()) {
        for (letter in 'A'..'Z') {
            append(letter)
        }

        println(this@OuterClass.toString()) // 正确引用外部函数的方式
        println(toString()) // 这里的toString()，实际是this.toString()，这里的this指的是StringBuilder接受者对象
        append("\nNow I know the alphabet")
    }
}

fun main(args: Array<String>) {
    println(alphabet())
    println()

    println(alphabet2())
    println()

    println(alphabet3())
    println()

    println(OuterClass().alphabet4())
}

