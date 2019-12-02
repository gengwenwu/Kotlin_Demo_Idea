package org.logan.test.kotlin.basic.cp05


/**
 * desc: 函数式编程 - Lambada。主要作用：
 * 1，将代码块作为函数参数传递。 <br/>
 * 2，和集合一起工作。<br/>
 *
 * 函数式编程提供一种解决方案：把函数当作值来对待，可以直接传递函数，而不需要先声明一个类再传递这个类的实例。<br/>
 *
 * time: 2019-09-05 11:25 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

fun testSimpleLambda() {
    //val button: Button? = null

    // 1，Java 事件监听器
    // button.setOnClickListener(new OnClickListener () {
    //     @Override
    //     public void onClick(View view) {
    //     }
    // });

    // 2，Java lambda形式 事件监听器
    // button.setOnClickListener(view -> {});


    // 3, Kotlin用lambda实现监听器
    //button?.setOnClickListener {}

    // 上面3种效果是一模一样的
}