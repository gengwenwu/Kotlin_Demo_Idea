package org.logan.test.kotlin.basic.cp04.ext4212

/**
 * desc: Kotlin类继承 <br/>
 * time: 2019-08-30 13:33 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

open class User(val nickname: String) // 使用open，让子类继承

class TwitterUser(nickname: String) : User(nickname) // 继承一个父类，主构造方法同样需要初始化父类


// 没有给一个类声明任何的构造方法，将会生成一个不做任何事情的默认构造方法
open class Button


// 必须显示地调用父类的构造方法，即使它没有任何的参数
// 注意与接口的区别：接口没有构造方法，所以你实现一个接口的时候，不需要在父类型列表中它的名称后面加上小括号。
class RadioButton : Button()


/**
 * 如果不想让类实例化，必须把构造方法标记为 private
 * 这里要留意一个问题，private的位置。
 * 1，在constructor前面，表示构造函数是private的。2，在class前面，表示class访问修饰符是private。
 * */
class Secretive private constructor()
