package org.logan.test.kotlin.basic.cp08

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

/**
 * desc: 使用内联 lambda 管理资源 <br/>
 * time: 2019/12/23 11:46 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    val l: Lock = ReentrantLock()

    l.withLock {
        // 在加锁的情况下执行指定的操作，注意看withLock()源代码，是try finally结构的
        // do something
    }
}

fun readFirstLineFromFile(path: String): String {
    /**
     * 使用 use 函数作资源管理。
     * use 函数是一个扩展函数，被用来操作可关闭的资源，它接收一个 lambda 作为参数。
     * 这个方法调用 lambda 并且确保资源被关闭，无论 lambda 正常执行还是抛出了异常。use函数是内联函数所以使用它并不会引发任何性能开销。
     **/

    // 构建 BufferedReader，调用use函数，传递一个lambda执行文件操作
    BufferedReader(FileReader(path))
        .use { br ->
            return br.readLine()
        }

}