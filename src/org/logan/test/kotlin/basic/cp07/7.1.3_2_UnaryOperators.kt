package org.logan.test.kotlin.basic.cp07

import java.math.BigDecimal

/**
 * desc: 重载一元运算符 ++ <br/>
 * time: 2019/12/11 3:00 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

// inc() 递增
operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main() {
    var bd = BigDecimal.ZERO

    println(bd++) // 执行println之后，再执行++

    println(++bd) // 执行执行++之后，再执行println
}