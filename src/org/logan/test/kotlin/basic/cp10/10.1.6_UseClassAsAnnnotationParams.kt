package org.logan.test.kotlin.basic.cp10

import ru.yole.jkid.DeserializeInterface
import ru.yole.jkid.deserialization.deserialize

/**
 * desc: 使用类做注解参数 <br/>
 * 可以参考JKid @DeserializeInterface注解
 *
 * time: 2019-09-07 22:17 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 接口
interface Company {
    val name: String
}

// 实现类
data class CompanyImpl(override val name: String) : Company


data class Person3(
    val name: String,

    /**
     * // 使用类作为注解参数。
     * 当JKid读到一个 Person类实例嵌套的 company对象时，它创建并反序列化了一个 CompanyImpl的实例，把它存储在 company属性中。
     * 使用名称后面跟上 ::class 关键字来引用一个类。如下方的：CompanyImpl::class
     * @DeserializeInterface 声明中，入参类型是KClass，它对标的是Java的 java.lang.Class类型。
     * KClass的类型参数说明了这个引用指向Kotlin某个类。 例如，CompanyImpl::class的类型是 KClass<CompanyImpl>
     **/
    @DeserializeInterface(CompanyImpl::class) val company: Company

)


fun main(args: Array<String>) {
    val json = """ {"name": "Alice", "company": {"name": "Microsoft"}} """
    val person = deserialize<Person3>(json)
    println(person)

}

