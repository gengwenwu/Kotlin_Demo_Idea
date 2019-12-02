package org.logan.test.kotlin.basic.cp05

/**
 * desc: 序列asSequence() <br/>
 * 序列操作分为两类：中间的和末端的。一次中间操作返回的是另一个序列，这个新序列知道如何变换原始序列中的元素。 <br/>
 * 而一次末端操作返回的是一个结果，这个结果可能是集合、元素 、数字，或者其他从初始集合的变换序列中获取的任意对象。 <br/>
 *
 * sequence
 *  .map{...}.filter{...} // 中间操作
 *  .toList() // 末端操作
 *
 * time: 2019-09-18 19:13 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main(args: Array<String>) {
    /**
     * 执行这段代码并不会在控制台上输出任何内容。这意味着 map 和 filter 变换被延期了，
     * 它们只有在获取结果的时候才会被调用 (即：末端操作被调用的时候)
     **/
    listOf(1, 2, 3, 4).asSequence()
        .map {
            // map 属于asSequence()之后的中间操作，返回的是另一个序列
            print("map($it) ")
            it * it
        }.filter {
            // filter 属于asSequence()之后的中间操作，返回的是另一个序列
            print("filter($it) ")
            it % 2 == 0
        }


    // 对序列来说，所有操作是按顺序应用在每一个元素上：处理完第一个元素(如下：先映射再过滤)，然后完成第二个元素的处理，以此类推。
    listOf(1, 2, 3, 4).asSequence()
        .map {
            print("map($it) ")
            it * it
        }.filter {
            print("filter($it) ")
            it % 2 == 0
        }.toList() // toList() 属于末端操作，它触发执行了所有的延期计算。


    println()
    /**
     * 下面两断代码虽然实现的功能一样，但是使用序列的性能会更好。原因：1，中间操作没有创建列表。 2，函数执行的次数也更少。
     **/
    // map的结果首先被求出来，即变换初始集合中的所有元素。第二步，中间集合中满足判断式的一个元素会被找出来。
    println(listOf(1, 2, 3, 4).map { it * it }.find { it > 3 })
    // 使用序列后，数据源3和4，都不会执行map，find操作。
    println(listOf(1, 2, 3, 4).asSequence().map { it * it }.find { it > 3 })


    println()
    /**
     * 在集合上执行操作的顺序也会影响性能。
     */
    val people =
        listOf(
            Person("Alice", 29), Person("Bob", 31),
            Person("Charles", 31), Person("Dan", 21)
        )

    // 先map、后filter
    println(people.asSequence().map(Person::name).filter { it.length < 4 }.toList())
    // 先filter(过滤掉不符合条件的数据)、后map (性能更好)
    println(people.asSequence().filter { it.name.length < 4 }.map(Person::name).toList())
    // 综上，如果map在前，每个元素都被变换。而如果filter在前，不合适的元素会被尽早地过滤掉且后面不会发生变换 。

}