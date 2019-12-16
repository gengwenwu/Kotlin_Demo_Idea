package org.logan.test.kotlin.basic.cp07.ext7521

/**
 * desc: 手动实现委托 -- 这个代码有点啰嗦 <br/>
 *       可以与7.5.2_2_LazyInitialization.kt代码对比。
 *
 * time: 2019/12/16 2:15 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Email { /*...*/ }

fun loadEmails(person: Person): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(/*...*/)
}

// Person展示了如何使用额外的 _emails 属性来实现惰性加载。
class Person(val name: String) {
    private var _emails: List<Email>? = null // _emails保存数据，关联委托

    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this) // 访问的时候，加载数据
            }
            return _emails!!
        }
}

fun main() {
    val p = Person("Alice")
    p.emails
    p.emails // 第二次访问没有初始化数据
}