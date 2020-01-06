package org.logan.test.kotlin.basic.cp08.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * desc: Java7 引入的 try-with-resource语句 <br/>
 * time: 2020/1/6 3:20 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class TryReadSource {

	static String readFirstLineFromFile(String path) throws IOException {

		// try-with-resource 语法
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}


}
