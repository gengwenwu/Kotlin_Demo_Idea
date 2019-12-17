package org.logan.test.kotlin.basic.cp07

/**
 * desc: 委托属性，下面都是伪代码 <br/>
 * time: 2019/12/16 1:38 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// 1，委托属性基本语法如下：
// class Foo {
//     // 关键字by把属性关联上委托对象，Delegate类的一个新的实例。
//     var p: Type by Delegate()
// }


// 2，上面的代码，编译器会创建一个隐藏的辅助属性(下面的delegate)，并使用委托对象的实例进行初始化，初始属性p会委托给该实例。
// class Foo {
//    private val delegate = Delegate() // 编译器创建的辅助属性，即：delegate (这里方便理解，故取名：delegate)
//
//    var p: Type // p 的访问都会调用 delegate 的 getValue() 和 setValue() 方法。
//        set(value: Type) = delegate.setValue(..., value)
//        get() = delegate.getValue(...)
// }


// 3, 按照约定，Delegate类必须具有 getValue() 和 setValue()方法 (后者仅适用于可变属性)。
//    它们可以是成员函数，也可以是扩展函数。
//
// class Delegate {
//    operator fun getValue(...) { // val 声明的变量
//        ....
//    }
//
//    operator fun setValue(..., value Type) { // var 声明的变量
//
//    }
//}

// fun main() {
//    val foo = Foo()
//    val oldValue = foo.p // 调用delegate.getValue(...)来实现属性的读取
//    foo.p = newValue // 调用 delegate.setValue(..., newValue)来实现属性的修改
// }