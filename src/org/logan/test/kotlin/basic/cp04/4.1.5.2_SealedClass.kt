package org.logan.test.kotlin.basic.cp04.ext1

/**
 * desc: Kotlin 密封类 - sealed <br/>
 * 1，sealed 只能在class中使用。  <br/>
 * 2，如果在when表达式中处理所有sealed子类，就不需要提供else分支。新增子类，所有when(sealed类对象)会立刻编译报错，强制你处理新增加的子类分支。 <br/>
 * 3，注意，sealed修饰符隐含的这个类是一个open类，你不再需要显示地添加open修饰符。 <br/>
 * -
 * time: 2019-08-29 19:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

sealed class Expr // 使用sealed修饰符，它会自动变成open的

// Expr 实现1
class Num(val value: Int) : Expr()

// Expr 实现2
class Sum(val left: Expr, val right: Expr) : Expr()

// Expr 实现3 (新增sealed子类)
class Digit(val value: Int) : Expr()


fun eval(e: Expr): Int =
    when (e) { // 使用sealed后，就不需要else分支。并且新增子类，强制要求你给该子类添加分支处理，如：Digit分支判断
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        is Digit -> e.value + 1 // 新增sealed子类
    }
