package org.logan.test.kotlin.basic.cp02

import org.logan.test.kotlin.basic.cp02.Color.*;

/**
 * desc: when结构能使用任何表达式作为分支条件，可以让代码很简洁 <br/>
 * time: 2019-08-22 17:40 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) { // when表达式的实参可以是任何对象，它被检查是否与分支条件相等
        setOf(RED, YELLOW) -> ORANGE // 两个set中包含一样的条目，它们就是相等
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty color")
    }


/**
 * 上面代码执行效率是低下的，每次调用都会创建set集合。<br/>
 * 为了达到较好的性能，需要付出一些代价。代码可读性会变差。<br/>
 * */
fun mix2(c1: Color, c2: Color) =
    when { // 不指定参数，以分支条件判断为准
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == BLUE && c2 == YELLOW) || (c1 == YELLOW && c2 == BLUE) -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
        else -> throw Exception("Dirty color")
    }


fun main(args: Array<String>) {

    println(mix(YELLOW, RED).toString() + " = " + mix(RED, YELLOW))

    println(mix2(YELLOW, RED).toString() + " = " + mix(RED, YELLOW))
}

