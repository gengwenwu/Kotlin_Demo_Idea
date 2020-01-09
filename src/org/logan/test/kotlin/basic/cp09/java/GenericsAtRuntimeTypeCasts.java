package org.logan.test.kotlin.basic.cp09.java;

import java.util.Collection;
import java.util.List;

/**
 * desc: Java运行时的泛型转换 <br/>
 * time: 2020/1/8 4:25 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class GenericsAtRuntimeTypeCasts {

	public static void printlnSum(Collection<?> c) {
		List<Integer> list = (List<Integer>) c;
	}

	public static void main(String[] args) {
		// Java中无法调用 reified 函数
		// _9_2_2_DeclaringFunctionsWithReifiedTypeParametersKt.isA()
	}
}
