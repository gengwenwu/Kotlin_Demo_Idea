# Kotlin lambda简单汇总

## 1, Kotlin lambda基本语法
Kotlin lambda 基本语法 `{x: Int, y: Int -> x + y}`，始终用花括号 `{}` 包围，箭头把实参列表和lambda的函数体隔开。
箭头左边是入参(注意，没有小括号包起来)，箭头后边是具体的实现。  

主要3种案例形式：   
* method { x, y -> x + y } // method只有一个lambda入参，而lambda体有多个入参，有返回值。
* method (param1) { x, y -> x + y }  // method多个入参，而lambda体恰好是最后一个入参。     
* method { it.value } // method只有一个lambda入参，而lambda体的入参恰好只有一个，使用it。  

更多的案例可以查看代码：  
* 5.1.3_LambdaExpressionSyntax1.kt 
* 5.1.3_LambdaExpressionSyntax2.kt 
* 5.1.3_LambdaExpressionSyntax3.kt 

## 2，Kotlin 函数类型
Kotlin拥有完全的`函数类型`，基本语法：`(Int, String) -> Unit`  
将函数参数类型放在括号中，紧接着是一个箭头和函数的返回类型。左边是入参，右边是返回值。  
  
`函数类型`主要3种形式：    
* `() -> Int`  // 无参数，有返回值   
* `(x) -> Unit ` // 有参数，无返回值   
* `(x, y) -> Boolean ` // 有参数，有返回值 

更多的案例可以查看 8.1.1_FunctionTypes.kt 代码。

## 3，Kotlin 函数类型原理
Kotlin 的 Functions.kt 文件生成了很多 FunctionN 接口(23个，0-22)，该接口对应 Kotlin 的函数类型。

## 4，Kotlin lambda特有性质
* 1，`被lambda捕获`。可以在 Kotlin 的 lambda 中修改外部变量值。
* 2，`inline`内联函数。(1)、提高lambda效率问题(避免生成匿名类)；(2)、结合`reified`使用，判断范型具体类型。
* 3，`asSequence`序列。处理大批量集合数据使用，与Java 8 的流很相似。
* 4，Kotlin 提供了多个作用域函数（`run`、`with`、`apply`、`let`、`also`），结合 lambda 一起使用。
* 5，`局部返回`、`非局部返回`。`局部返回`需要结合标签使用。
* 6，`匿名函数`。在多个局部返回使用。
* 7，lambda 体中的 `this` 指向的是外部的对象。