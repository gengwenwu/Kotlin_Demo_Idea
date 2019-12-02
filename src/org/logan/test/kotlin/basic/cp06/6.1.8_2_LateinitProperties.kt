package org.logan.test.kotlin.basic.cp06.ext

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.logan.test.kotlin.basic.cp06.MyService

/**
 * desc: 延迟初始化的属性 - lateinit关键字 <br/>
 * lateinit 专门用于非空属性的延迟初始化，常见的一种用法是依赖注入。<br/>
 *
 * time: 2019-09-28 11:47 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class MyService {
    fun performAction(): String = "foo"
}


class MyTest {
    // lateinit 属性必须是 var的
    private lateinit var myService: MyService // 声明一个不需要初始化器的非空类型的属性

    @Before
    fun setUp() {
        myService = MyService() // 初始化属性
    }


    @Test
    fun testAction() {
        Assert.assertEquals(
            "foo",

            // 如果myService运行时为null，会抛出：lateinit property myService has not been initialized
            myService.performAction() // 语法上，不需要null检查可直接访问。即：不需要用!! 或 ?.
        )
    }

}