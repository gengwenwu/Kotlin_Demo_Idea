package org.logan.test.kotlin.basic.cp09

/**
 * desc: 让类型形参非空 <br/>
 *       没有指定上界的类型形参将会使用 Any?，这个是默认的上界。
 *       此时的范型T可能为null。
 *
 * time: 2020/1/8 2:57 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Processor<T> { // 但是这里的T是可空的，因为默认T继承Any?

    fun process(value: T) {
        // value.hashCode() // value是可空的，这样调用可能导致空指针
        value?.hashCode() // value 安全调用
    }
}

// 通过指定约束实现T非空
class Processor2<T : Any> { // 指定非"空"上届，约束<T : Any>确保了类型 T 永远都是非空类型。
    //                         注意，可以通过指定任意非空类型作为上界，来让类型参数非空，不光是类型Any。

    fun process(value: T) {
        value.hashCode() // 类型T的值现在是非"空"的
    }
}


fun main() {
    val nullableStringProcessor = Processor<String?>() // 可空类型String?代替T
    nullableStringProcessor.process(null) // 使用null作为value实参的代码可以编译
    // val nullableStringProcessor2 = Processor2<String?>() // String?编译报错，只能接受非空，即：String

}

