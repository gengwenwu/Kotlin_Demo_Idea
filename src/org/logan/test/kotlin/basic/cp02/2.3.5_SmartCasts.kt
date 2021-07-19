package org.logan.test.kotlin.basic.cp02

/**
 * desc: 智能转换 is 关键字。<br/>
 * 智能转换只在变量经过了is检查且之后不再发生变化的情况下有效。<br/>
 * 当你对一个类的属性进行智能转换后，<br/>
 *      1, 这个属性必须是一个val属性，<br/>
 *      2，而且不能有自定义的访问器 get()。 <br/> TODO Logan 待确认？
 * <p>
 * 否则，每次对属性的访问, 是否 能返回同样的值将无从验证。<br/>
 * time: 2019-08-22 19:18 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
interface Expr

class Num(val value: Int) : Expr // 声明类，并实现Expr接口
class Sum(val left: Expr, val right: Expr) : Expr


fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num // 使用as关键字显示转换成Num，是多余的操作
        return e.value // 智能转换后，绿色背景高亮提示
    }

    if (e is Sum) { // 通过is判断后，下面的代码的e，已经智能转换成对应的对象
        return eval(e.left) + eval(e.right)
    }

    throw IllegalArgumentException("Unknown expression")
}


/**
 * 简化 eval()函数 - if表达式 <br/>
 * 1，省略花括号。如果 if分支中只有一个表达式，最外层花括号省略掉。<br/>
 * 2，去掉return。如果 if分支是一个代码块，代码块中的最后一个表达式被作为结果返回。<br/>
 **/
fun eval2(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.left) + eval(e.right)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }


/**
 * if表达式代码块 <br/>
 * if 和 when 都可以使用 代码块 作为分支体。这种情况下，代码块中的最后一个表达式就是结果。<br/>
 * 规则：“代码块中最后的表达式就是结果”，在所有使用代码块并期望得到一个结果的表达式都成立。<br/>
 * 这个规则对常规函数不成立。一个函数要么是表达式体函数，要么具有包含显示return语句的代码块函数体。<br/>
 **/
fun evalWithLog(e: Expr): Int =
    when (e) {
        //
        is Num -> { // 码块作为分支体
            println("num: ${e.value}")
            e.value
        }
        //
        is Sum -> {
            println("sum: ${eval(e.left) + eval(e.right)}")
            eval(e.left) + eval(e.right)
        }
        //
        else -> throw IllegalArgumentException("Unknown expression")
    }
