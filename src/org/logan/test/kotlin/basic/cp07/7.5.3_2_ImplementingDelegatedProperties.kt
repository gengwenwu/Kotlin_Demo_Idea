package org.logan.test.kotlin.basic.cp07.ext7532

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

/**
 * desc: 实现委托属性 - PropertyChangeSupport、PropertyChangeListener <br/>
 *       通过辅助类ObservableProperty来实现属性变化的通知。
 *
 *       下面代码看完之后，你就知道委托属性是如何工作的：你创建了一个保存属性值的类(ObservableProperty)，
 *       并在修改属性时自动触发更改通知。你删除了重复的逻辑代码，但是需要相当多的样板代码来为每个属性创建
 *       ObservableProperty 实例， 井把getter和setter委托给它。
 *
 *       优化见：7.5.3_3_ImplementingDelegatedProperties.kt
 *
 * time: 2019/12/16 3:45 下午 <br/>
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

// 通过辅助类ObservableProperty来实现属性变化的通知
class ObservableProperty(
    val propName: String, var propValue: Int,
    val changeSupport: PropertyChangeSupport
) {
    fun getValue(): Int = propValue

    fun setValue(newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName, oldValue, newValue)
    }
}

class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    val _age = ObservableProperty("age", age, changeSupport) // 使用ObservableProperty辅助类
    val _salary = ObservableProperty("salary", salary, changeSupport)

    var age: Int
        get() = _age.getValue()
        set(value) {
            _age.setValue(value)
        }

    var salary: Int
        get() = _salary.getValue()
        set(value) {
            _salary.setValue(value)
        }
}

fun main() {
    val p = Person("Alice", 34, 2000)
    p.addPropertyChangeListener(PropertyChangeListener { event ->
        // 设置监听器，监听属性修改
        println(
            "Property ${event.propertyName} changed, " +
                    "from ${event.oldValue} to ${event.newValue}"
        )
    })

    p.age = 35 // 修改属性
    p.salary = 2100 // 修改属性
}