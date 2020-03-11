package org.logan.test.kotlin.basic.cp09

import kotlin.reflect.KClass

/**
 * desc: 使用星号投影例子 <br/>
 * time: 2020/3/11 1:44 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
interface FieldValidator<in T> { // 接口定义成在 T 上逆变，这里很重要，是下面例子的根基。

    fun validate(input: T): Boolean // T 只在in位置使用 (只能消费)
}

object DefaultStringValidator : FieldValidator<String> {
    override fun validate(input: String) = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int> {
    override fun validate(input: Int) = input >= 0
}


fun main() {
    val validators = mutableMapOf<KClass<*>, FieldValidator<*>>() //使用*，表示未知类型
    validators[String::class] = DefaultStringValidator
    validators[Int::class] = DefaultIntValidator

    // 1，下面代码 '.validate()' 编译报错
    // validators[String::class]!!.validate("") //存储在map中的值的类型是FieldValidator<*>
    // Error: Out-projected type ’FieldValidator<*>’ prohibits the use of 'fun validate (input: T) : Boolean'


    // 2，在 9.3.6_1_StartProjection.kt 中的 unknownElements.add(42) 写入元素的时候，你已经见过这个错误了。
    // 这种情况下，这个错误的意思是：把具体类型的值传给未知类型的验证器是不安全的。


    // 3，一种修正的方法是把验证器显式地转换成需要的类型。这样做是不安全的，也是不推荐的。
    // 但我们还是把它作为让代码快速通过编译的技巧展示在这里，这样可以在后面来重构它。
    val stringValidator = validators[String::class]
            as FieldValidator<String> // 警告：未受检的转换，不推荐的写法。
    println(stringValidator.validate(""))


    // 4，运行时报错 例子
    val stringValidator2 = validators[Int::class] // 不小心写成Int::class，本应该是String::class
            as FieldValidator<String>
    println(stringValidator2.validate("")) // 运行时报错，ClassCastException: String cannot be cast to Number


    // 解决方案见：9.3.6_4_FieldValidator.kt

}

