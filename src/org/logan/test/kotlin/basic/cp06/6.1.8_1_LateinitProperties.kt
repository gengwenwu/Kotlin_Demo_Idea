package org.logan.test.kotlin.basic.cp06

import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * desc: 延迟初始化的属性 <br/>
 * 下面例子，是我们对可空属性的一般做法，但是它导致的问题：使用这些属性必须对空进行处理，如：使用!! 或 ?. <br/>
 * 但是 6.1.8_2_LateinitProperties.kt 提供了更好的解决方案。<br/>
 *
 * time: 2019-09-28 11:39 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class MyService {
    fun performAction(): String = "foo"

}

class MyTest {
    private var myService: MyService? = null // 声明一个可空属性

    @Before
    fun setUp() {
        myService = MyService() // 初始化属性
    }


    @Test
    fun testAction() {
        Assert.assertEquals(
            "foo",
            myService!!.performAction() // 必须注意可空性：要么用!!，用么用 ?.
        )
    }

}