package org.logan.test.kotlin.basic.cp03

/**
 * desc: 局部函数和扩展，让代码更整洁<br/>
 * time: 2019-08-27 15:19 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class User(val id: Int, val name: String, val address: String)


// 带重复代码的函数
fun saveUser1(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("user name is empty")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("user address is empty")
    }

    // save user to database
}


// 优化1：提取局部函数来避免重复
fun saveUser2(user: User) {

    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("user ${user.id} ${fieldName} is empty")
        }
    }

    // validate调用，一定要在声明之下
    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

    // do something
}

// 优化2：在局部函数中访问外层函数的参数
fun saveUser3(user: User) {
    fun validate(value: String, fieldName: String) { // 现在不用在saveUser函数中重复user参数了
        if (value.isEmpty()) {
            throw IllegalArgumentException("user ${user.id} ${fieldName} is empty") // 可以直接访问外部函数的参数
        }
    }

    // do something
}

// 优化3：提取逻辑到扩展函数
fun saveUser4(user: User) {
    user.validateBeforeSave()
    // do something
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw java.lang.IllegalArgumentException("user ${id} ${fieldName} is empty")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}