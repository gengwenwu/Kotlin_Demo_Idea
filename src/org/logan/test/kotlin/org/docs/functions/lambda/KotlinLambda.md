# Kotlin lambda简单汇总

## 1, Kotlin lambda基本形式
Kotlin lambda 一定需要包在 `{ }` 中，主要3种形式：  
* object (param1) { x, y -> x + y }  // object多个参数，lambda体是最后一个参数。     
* object { x, y -> x + y } // 只有一个lambda体参数，lambda体有多个入参，有返回值。  
* object { it.value } // 只有一个lambda 入参，lambda参数只有一个，使用it  

## 2，Kotlin 函数类型
Kotlin 的`函数类型`主要3种形式：  
* `() -> Int`  // 无参数，有返回值   
* `(x) -> Unit ` // 有参数，无返回值   
* `(x, y) -> Boolean ` // 有参数，有返回值 

## 3，Kotlin 函数类型原理
Kotlin 的 Functions.kt 文件生成了很多 FunctionN 接口(23个，0-22)，该接口对应 Kotlin 的函数类型。

## 4，Kotlin lambda特有性质
* 1，`被lambda捕获`。可以在 Kotlin 的 lambda 中修改外部变量值。
* 2，`inline`内联函数。(1)、提高lambda效率问题(避免生成匿名类)；(2)、结合`reified`使用，判断范型具体类型。
* 3，`asSequence`序列。处理大批量集合数据使用，与Java 8 的流很相似。
* 4，Kotlin 提供了多个作用域函数，结合 lambda 一起使用。`run`、`with`、`apply`、`let`、`also`。
* 5，`局部返回`、`非局部返回`。`局部返回`需要结合标签使用。
* 6，`匿名函数`。在多个局部返回使用。
* 7，lambda 体中的 `this` 指向的是外部的对象。