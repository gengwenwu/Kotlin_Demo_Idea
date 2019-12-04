package org.logan.test.kotlin.basic.cp06.java;

import java.util.List;

/**
 * desc:  <br/>
 * time: 2019/12/4 10:51 AM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public class CollectionUtils {

	public static List<String> uppercaseAll(List<String> items) {
		for (int i = 0; i < items.size(); i++) {
			// java代码，不管Kotlin可读与否，都能进行修改数据
			items.set(i, items.get(i).toUpperCase());
		}

		return items;
	}

}
