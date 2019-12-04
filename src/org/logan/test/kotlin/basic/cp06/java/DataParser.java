package org.logan.test.kotlin.basic.cp06.java;

import java.util.List;

/**
 * desc:  <br/>
 * time: 2019/12/4 11:47 AM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public interface DataParser<T> {

	void parseData(String input, List<T> output, List<String> errors);
}
