package org.logan.test.kotlin.basic.cp10.java;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * desc: Java 注解  <br/>
 * time: 2019-09-07 15:24 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER}) //用在字段、函数、构造函数中
@Retention(RetentionPolicy.RUNTIME)
public @interface Ann {

}
