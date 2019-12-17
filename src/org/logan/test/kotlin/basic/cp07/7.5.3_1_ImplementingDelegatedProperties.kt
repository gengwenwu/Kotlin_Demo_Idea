package org.logan.test.kotlin.basic.cp07.ext7531

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

/**
 * desc: 实现委托属性 - PropertyChangeSupport、PropertyChangeListener <br/>
 *       优化见：7.5.3_2_ImplementingDelegatedProperties.kt
 *
 * time: 2019/12/16 2:54 下午 <br/>
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

// Person类
class Person(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field // field 标识符允许你访问属性背后的支持字段
            field = newValue
            changeSupport.firePropertyChange("age", oldValue, newValue) // 当属性变化，通过监听器
        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}

fun main() {
    val p = Person("Alice", 34, 2000)
    p.addPropertyChangeListener(PropertyChangeListener { event -> // 设置监听器，监听属性修改
        println(
            "Property ${event.propertyName} changed, " +
                    "from ${event.oldValue} to ${event.newValue}"
        )
    })

    p.age = 35 // 修改属性
    p.salary = 2100 // 修改属性
}