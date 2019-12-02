package org.logan.test.kotlin.basic.cp10.java;

/**
 * desc: Java 中 value方法很特殊：当你应用一个注解时，你需要提供value以外所有指定特性显式名称。 <br/>
 * time: 2019-09-07 18:51 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public @interface JsonNameInJava {

    String value();

    String value2();

}
