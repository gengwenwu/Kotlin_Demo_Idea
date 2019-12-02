package org.logan.test.kotlin.basic.cp03.java;

import org.logan.test.kotlin.basic.cp03._3_3_1_1_ExtensionMethodKt;

/**
 * desc: Java调用扩展函数 <br/>
 * time: 2019-08-26 16:33 <br/>
 * author: Logan <br/>
 * since V 1。0 <br/>
 */
public class _3_3_2_CallExtensionMethod {

    public static void main(String[] args) {

        // “Kotlin”接收者对象作为参数传递进去
        char c = _3_3_1_1_ExtensionMethodKt.lastChar("Kotlin");
        System.out.println("c:" + c);
    }

}