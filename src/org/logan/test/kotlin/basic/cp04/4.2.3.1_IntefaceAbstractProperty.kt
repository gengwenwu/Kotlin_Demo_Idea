package org.logan.test.kotlin.basic.cp04

/**
 * desc: kotlin接口的抽象属性 <br/>
 * 1，接口本身并不允许包含任何状态，因此只有实现这个接口的类，在需要的情况下会存储这个值。<br/>
 * 2，接口还可以包含具有getter和setter的属性。<br/>
 *-
 * time: 2019-09-01 16:35 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
interface User6 {
    val nickname: String // 在Kotlin中，接口可以包含抽象属性声明。
}

// 实现接口抽象属性 方式一： 在主构造使用override，变量名称必须与抽象属相同
class PrivateUser(override val nickname: String) : User6


// 实现接口抽象属性 方式二：使用自定义getter
class SubscirbingUser(val email: String) : User6 {
    override val nickname: String // 注意: 必须加关键字override
        get() = email.substringBefore('@')

}

// 实现接口抽象属性 方式三：通过函数初始化
class FaceBookUser(accountId: Int) : User6 {
    override val nickname = getFacebookName(accountId) // 注意: 必须加关键字override
}

fun getFacebookName(accountId: Int) = "fb:" + accountId


// 这个接口的email属性必须在子类中重写，而nickname是可以被继承的
interface User7 {
    val email: String

    val nickname: String // 接口还可以包含具有getter和setter的属性
        get() = email.substringBefore('@')

}