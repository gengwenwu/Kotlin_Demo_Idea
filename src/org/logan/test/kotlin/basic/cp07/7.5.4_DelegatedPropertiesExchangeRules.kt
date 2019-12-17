package org.logan.test.kotlin.basic.cp07

/**
 * desc: 委托属性的变换规则 <br/>
 * time: 2019/12/17 4:01 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 总结一下委托属性是怎么工作的，下面是伪代码

// 1，一个具有委托属性的类
// class C {
//     var prop: Type by MyDelegate()
// }


// 2，编译器生成的代码
// class C {
//    private val <delegate> = MyDelegate() // MyDelegate实例会被保存到一个隐藏的属性中，它被称为<delegate>
//
//    var prop: Type
//        get() = <delegate>.getValue(this, <property>) // 编译器也将用一个KProperty类型的对象来代表这个属性，它被称为<property>。
//        set(value: Type) = <delegate>.setValue(this, <property>, value)
// }

//3，在每个属性访问器中，编译器都会生成对应的 getValue 和 setValue 方法
// val x = c.prop  -->  val x = <delegate>.getValue(c, <property>)
// c.prop          -->  <delegate>.setValue(c, <property>, x)