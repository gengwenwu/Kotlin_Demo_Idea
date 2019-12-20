package org.logan.test.kotlin.basic.cp08.ext8152

/**
 * desc: 返回函数的函数 <br/>
 * time: 2019/12/19 7:01 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

// 联系人过滤器
class ContractListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean { // 声明返回高阶函数

        val startsWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }

        if (!onlyWithPhoneNumber) {
            return startsWithPrefix // 返回一个函数类型的变量
        }

        return { startsWithPrefix(it) && it.phoneNumber != null } // 返回一个lambda
    }
}

fun main() {
    val contacts = listOf(
        Person("Dmitry", "Jemerov", "123-4567"),
        Person("Svetlana", "Isakova", null)
    )

    val contactListFilters = ContractListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }

    // 将getPredicate返回的函数作为参数传递给filter函数
    println(contacts.filter(contactListFilters.getPredicate()))

}