package org.logan.test.kotlin.basic.cp10

/**
 * desc: 元注解 <br/>
 * 和Java一样，一个Kotlin注解类自己也可以被注解。可以应用到注解类上的注解被称作元注解。<br/>
 * 标准库定义的元注解中最常见是：
 *  1，@Target 2，@Retention
 *
 * time: 2019-09-07 19:27 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

/**
 * 1, @Target
 * 说明可以被应用的元素类型。如果不使用它，所有的声明都可以应用这个注解。<br/>
 * AnnotationTarget枚举的值列出了可以应用注解的全部可能的目标，<br/>
 * 包括：类、文件、函数、属性、属性访问器、所有的表达式等等。<br/>
 **/
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class JsonExclude2

// 2，声明多个目标
@Target(AnnotationTarget.CLASS, AnnotationTarget.LOCAL_VARIABLE)
annotation class JsonExclude3


// 3， 声明自定义元注解，使用 AnnotationTarget.ANNOTATION_CLASS
@Target(AnnotationTarget.ANNOTATION_CLASS)
annotation class BindingAnnotation

@BindingAnnotation
annotation class MyBinding


// 4，在Java代码中无法使用目标为PROPERTY的注解，如果需要在Java支持，需要添加FIELD
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.FIELD)
annotation class PropertyCompatibleInJavaAndKotlin


/**
 * 5，@Retention 说明声明的注解是否会存储到.class文件，以及在运行时是否可以通过反射来访问它。
 *  Java 默认会在.class文件中保留注解，但不会让它们在运行时被访问到。
 *  Kotlin 默认的是拥有RUNTIME保留期。
 **/
annotation class Ann4Retention