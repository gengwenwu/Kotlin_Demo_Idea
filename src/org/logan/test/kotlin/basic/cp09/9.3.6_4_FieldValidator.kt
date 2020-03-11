package org.logan.test.kotlin.basic.cp09

import kotlin.reflect.KClass

/**
 * desc: 使用星号投影例子，重构 9.3.6_3_FieldValidator 例子。<br/>
 * time: 2020/3/11 2:05 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 把所有对validators的访问封装到了两个泛型方法中，它们负责保证只有正确的验证器被注册和返回。
// 这段代码依然会发出未受检转换的警告，但这里的 Validators 控制了所有对 map 的访问，保证了没有任何人会错误地改变map。
object Validators {

    // validators私有化
    private val validators = mutableMapOf<KClass<*>, FieldValidator<*>>()

    // 注册 validator
    fun <T : Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>) {
        validators[kClass] = fieldValidator // 只有正确的键值对才能被写入Map，即：验证器正好对应类的时候
    }

    // 获取 validator
    operator fun <T : Any> get(kClass: KClass<T>): FieldValidator<T> =
        validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}


fun main() {
    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultIntValidator)

    // 1，正确例子
    println(Validators[String::class].validate("Kotlin"))
    println(Validators[Int::class].validate(42))


    // 2，下面代码 '.validate(42)' 编译报错
    // println(Validators[String::class].validate(42))
    // Error: The integer literal does not conform to the expected type String

    // 因为"get"方法（[String:class]）返回的是FieldValidator<String>实例，所以传递数值 42，是非法参数。
    // 这样所有不安全的逻辑都被隐藏在Validators中，通过把这些逻辑局部化，保证了它不会被错误地使用。

    // 这种模式可以轻松地推广到任意自定义泛型类的存储。把不安全的代码局部化到一个分开的位置预防了误用，而且让容器的使用变得安全。
    // 注意：这里描述的模式并不只是针对 Kotlin， 在 Java 中也可以使用同样的方法。

    // 泛型和变型往往被认为是 Java 语言中最难处理的部分。
    // 在 Kotlin 中力图拿出一个易读且易用的设计方案，同时保留和Java之间的互操作性。

}