package org.logan.test.kotlin.basic.cp04

/**
 * desc: 修改访问器的可见性 <br/>
 * time: 2019-09-01 17:34 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class LengthCounter {

    var counter: Int = 0 // getter 是 pubic
        private set // setter 是 private，不能在类外部修改这个属性


    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hi !")
    println(lengthCounter.counter)

}