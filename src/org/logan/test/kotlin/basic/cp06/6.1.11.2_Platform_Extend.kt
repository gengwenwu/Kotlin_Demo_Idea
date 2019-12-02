package org.logan.test.kotlin.basic.cp06

import org.logan.test.kotlin.basic.cp06.java.StringProcessor

/**
 * desc: 平台类型 - 继承问题，kotlin继承、实现java类、接口 <br/>
 * 在实现 Java类或者接口的方法时一定要搞清楚它的可空性。因为方法的实现可以在非 Kotlin 的代码中被调用，
 * Kotlin 编译器会为你声明的每一个非空的参数生成非空断言。 如果Java代码传给这个方法一个 null值，断言将会触发，
 * 你会得到一个异常，即便你从没有在你的实现中访问过这个参数的值。
 *
 * time: 2019-11-26 16:13 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class StringPrinter : StringProcessor {

    override fun process(value: String) { // 非null
        println(value)
    }
}

class NullableStringPrinter : StringProcessor {

    override fun process(value: String?) {// 可null
        if (value != null) {
            println(value)
        }
    }
}