package org.logan.test.kotlin.basic.cp07.ext7533

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

/**
 * desc: 实现委托属性 - PropertyChangeSupport、PropertyChangeListener <br/>
 *       优化 ObservableProperty，并使用by关键字
 *
 *       优化见：7.5.3_4_ImplementingDelegatedProperties.kt
 *
 * time: 2019/12/16 6:51 下午 <br/>
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

// 改进1，将propName从主构造方法中删除，可以通过KProperty访问。
class ObservableProperty(
    var propValue: Int, val changeSupport: PropertyChangeSupport
) {
    // 改进2，getValue() 和 setValue() 标记为operator并添加了几个入参
    operator fun getValue(p: Person, prop: KProperty<*>): Int = propValue

    operator fun setValue(p: Person, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class Person(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    // 改进3，使用by关键字。
    // Kotlin 编译器会自动执行之前版本的代码中手动完成的操作。使用委托属性时生成的代码非常类似。by右边的对象被称为委托。
    // Kotlin 会自动将委托存储在隐藏的属性中，并在访问或修改属性时调用委托的 getValue 和 setValue。
    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
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