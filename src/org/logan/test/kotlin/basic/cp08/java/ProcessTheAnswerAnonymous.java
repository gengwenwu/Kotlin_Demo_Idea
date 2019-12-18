package org.logan.test.kotlin.basic.cp08.java;

import org.logan.test.kotlin.basic.cp08.ProcessTheAnswer;

import java.util.ArrayList;
import java.util.List;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/**
 * desc: Java 调用Kotlin 函数类 <br/>
 * <p>
 * time: 2019/12/18 4:35 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class ProcessTheAnswerAnonymous {

	public static void main(String[] args) {
		// JDK 8.0 之前版本实现方式
		ProcessTheAnswer.processTheAnswer(new Function1<Integer, Integer>() { // Function1()
			@Override
			public Integer invoke(Integer number) {
				return number + 1;
			}
		});

		// JDK 8.0 之后版本实现方式
		ProcessTheAnswer.processTheAnswer(number -> number + 1); // java lambda 写法


		// 在 Java 中可以很容易地使用 Kotlin 标准库中以 lambda 作为参数的扩展函数。但是要注意它们看起来并
		// 没有 Kotlin 中那么直观，必须要显式地传递一个接收者对象作为第一个参数，可以对比8.1.3_1_ProcessTheAnswer.kt例子。
		List<String> strings = new ArrayList<>(2);
		strings.add("42");

		CollectionsKt.forEach(strings, s -> {
			System.out.println(s);
			return Unit.INSTANCE;
			// 在Java中，函数或者lambda可以返回 Unit。但因为在 Kotlin 中 Unit类型是有一个值的，所以需要显式地返回它。
			// 一个返回 void 的 lambda 不能作为返回 Unit 的函数类型的实参，就像之前的例子中的(String) -> Unit。
		});

	}

}
