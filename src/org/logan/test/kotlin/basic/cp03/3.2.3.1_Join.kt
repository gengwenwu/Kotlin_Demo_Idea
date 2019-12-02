// 注解指定类名。通过@JvmName注解，将_3_2_3_1_JoinKt 文件名修改为指定的类名StringFunctions
// @file:JvmName("StringFunctions") // 放在package之前

package org.logan.test.kotlin.basic.cp03

/**
 * desc: Kotlin顶层函数 <br/>
 * 1, 可以代替Java的 Util工具类。<br/>
 * 2, 以文件名 + Kt字符生成java class类。 <br/>
 * time: 2019-08-26 15:06 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun joinToString(): String {
    // Java 调用该函数: _3_2_3_1_JoinKt.joinToString() , 以静态方式调用。
    return ""
}

//  上面例子Java代码
//  public static String joinToString() {
//      return ""
//  {
