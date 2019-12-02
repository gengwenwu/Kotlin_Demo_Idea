package org.logan.test.kotlin.basic.cp05

import java.io.File

/**
 * desc: 创建序列，使用generateSequence() <br/>
 *
 * time: 2019-09-19 10:41 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {

    // 这个例子中的，naturalNumbers 和 numbersTolOO 都是有延期操作的序列。
    val natureNumbers = generateSequence(0) { it + 1 } // 使用generateSequence()生成一个序列（Sequence）
    val numberTo100 = natureNumbers.takeWhile { it <= 100 } // Sequence定了很多扩展函数，如这里的takeWhile
    println(numberTo100.sum()) // 执行sum()的时候，将所有的序列统一执行


    val file = File("/gengwenwu/gengwenwu.github.io")
    println(file.isInsideHiddenDirectory())

}

fun File.isInsideHiddenDirectory() =
    generateSequence(this) {
        it.parentFile
    }.any {
        it.isHidden
    }
