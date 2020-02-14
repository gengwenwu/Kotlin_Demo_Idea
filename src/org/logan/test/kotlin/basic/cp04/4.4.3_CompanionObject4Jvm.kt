package org.logan.test.kotlin.basic.cp04

/**
 * desc: Kotlin object关键字用法2 - 伴生对象的：@JvmStatic，@JvmField。 <br/>
 * 这两个注解都是与Java都互操作性而存在。<br/>
 *
 * time: 2019-09-03 11:50 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class Annotation {
    /**
     * 伴身对象中的变量 <br/>
     * 1，name属于Annotation类，private static <br/>
     * 2，仅Companion 提供了name的getter和setter <br/>
     **/
    companion object {
        var name: String = ""
    }
}

/**
 * 使用@JvmStatic <br/>
 * 1，name属于AnnotationJvmStatic类，private static <br/>
 * 2，AnnotationJvmStatic、Companion 都提供了name的getter和setter <br/>
 **/
class AnnotationJvmStatic {
    companion object {
        @JvmStatic
        var name: String = ""
    }
}

/**
 * 使用@JvmField <br/>
 * 1，name属于AnnotationField类，public static <br/>
 * 2，AnnotationField、Companion 没有关于name的getter和setter <br/>
 **/
class AnnotationField {
    companion object {
        @JvmField
        var name: String = ""
    }
}
