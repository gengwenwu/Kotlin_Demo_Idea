package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin 密封类 - 未实现密封类的情况 <br/>
 * time: 2019-08-29 15:39 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

interface Expr

// Expr 实现1
class Num(val value: Int) : Expr

// Expr 实现2
class Sum(val left: Expr, val right: Expr) : Expr

// Expr 实现3
class Digit(val value: Int) : Expr


fun eval(e: Expr): Int =
    when (e) { // 新添加 Digit子类后，但这里的判断分支并对它进行处理，这样很可能给程序带来bug。
        is Num -> e.value
        is Sum -> eval(e.right) + eval(e.left)
        else -> // 语法上必须有else分支
            throw IllegalArgumentException("Unknown expression")
    }
