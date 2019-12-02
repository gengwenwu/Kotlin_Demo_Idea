package org.logan.test.kotlin.basic.cp06

/**
 * desc: Kotlin 非空断言，双感叹号表示 !! <br/>
 * !! 可以把任何值转换成非空类型，如果对 null值做非空断言，则会抛出空指针异常。<br/>
 *
 * foo!!
 *      如果foo!=null，把foo!!转换成非空类型foo。
 *      如果foo==null，立即会抛出NullPointerException。<br/>
 *
 * time: 2019-09-26 19:09 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull)
}

fun main(args: Array<String>) {
    ignoreNulls("has String value, no problem!")
    ignoreNulls(null) // 抛出异常


    val person = Person("Alice", Company("Alibaba", null))
    person.company!!.address!!.country // 不要这么写，因为异常的跟踪信息只表明异常发生在哪一行代码，而不会表明异常发生在哪一个表达式 。


    person.company!!
    person.company ?: return // 如果不希望写!!，可以使用这种语法

}
