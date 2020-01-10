package org.logan.test.kotlin.basic.cp09

import com.sun.deploy.services.Service
import java.util.*

/**
 * desc: 使用实化类型参数代替类引用(java.lang.Class) <br/>
 *
 * 另一种实化类型参数的常见使用场景是：为接收 java.lang.Class 类型参数的 API 构建适配器。
 *
 * time: 2020/1/9 11:24 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun main() {
    // 使用标准的 ServiceLoader Java API 加载一个服务
    val serviceImpl = ServiceLoader
        .load(Service::class.java) // ::class.java 语法展现了如何获取 java.lang.Class 对应的 Kotlin 类，
    //                                这和 Java 中的 Service.class 是完全等同的。

    // 优化
    val serviceImpl2 = loadService<Service>()
}

// 重写带实化类型参数的函数
inline fun <reified T> loadService(): ServiceLoader<T>? { // 类型参数标记成了 reified
    return ServiceLoader.load(T::class.java) // 把 T::class 当成类型形参的类访问，
    //                                          使用这种语法会产生对应到指定为类型参数的类的java.lang.Class对象
}


// 简化 Android 的 startActivity()
// inline fun <reified T : Activity> Context.startActivity() {
//    val intent = Intent(this, T::class.java)
//    startActivity(intent)
// }

// 跳转详情页
// startActivity<DetailActivity>()