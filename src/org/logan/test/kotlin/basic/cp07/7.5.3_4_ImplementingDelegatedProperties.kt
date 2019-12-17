package org.logan.test.kotlin.basic.cp07.ext7534

import org.logan.test.kotlin.basic.cp07.ext7533.Person
import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * desc: 实现委托属性(最终版本) <br/>
 *       可以使用 Kotlin标准库，实现类似于 ObservableProperty功能。
 *
 * time: 2019/12/17 3:17 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
// PropertyChangeSupport工具类
open class PropertyChangeAware {

    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }


    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}


class Person(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    // 改进一，使用表达式
    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    // 改进二，使用Delegates.observable()
    // by 右边的表达式不一定是新创建的实例，也可以是函数调用、另一个属性或任何其他表达式，只要这个表达式的值，
    // 是能够被编译器用正确的参数类型来调用 getValue 和 setValue 的对象。
    // 与其他约定一样， getValue 和 setValue 可以是对象自己声明的方法或扩展函数。
    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

fun main() {
    val p = Person("Alice", 34, 2000)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println(
                "Property ${event.propertyName} changed, " +
                        "from ${event.oldValue} to ${event.newValue}"
            )
        }
    )

    p.age = 35
    p.salary = 2100
}