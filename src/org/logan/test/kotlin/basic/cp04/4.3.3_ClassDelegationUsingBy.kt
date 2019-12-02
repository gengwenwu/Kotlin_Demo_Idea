package org.logan.test.kotlin.basic.cp04

/**
 * desc: 使用“by”关键字实现类委托 <br/>
 * Kotlin将委托作为一个语言级别的功能做了支持。无论什么时候实现一个接口，都可以使用by将接口的实现委托给另一个对象。<br/>
 *
 * time: 2019-09-01 21:09 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet { // 将MutableCollection委托给innerSet

    var objectAdded = 0

    // 自定义add()实现，不使用委托对象的MutableCollection.add()
    override fun add(element: T): Boolean {
        objectAdded++
        return innerSet.add(element)
    }

    // 自定义addAll()实现，不使用委托对象的MutableCollection.addAll()
    override fun addAll(elements: Collection<T>): Boolean {
        objectAdded += elements.size
        return innerSet.addAll(elements)
    }

}

fun main(args: Array<String>) {
    val cset = CountingSet<Int>()

    cset.addAll(listOf(1, 2, 3))
    cset.add(4)

    println("${cset.objectAdded} objects were added, ${cset.size} remain")
}


class DelegatingCollection<T>(
    innerList: Collection<T> = ArrayList<T>()
) : Collection<T> by innerList { // 将Collection委托给innerList

}
