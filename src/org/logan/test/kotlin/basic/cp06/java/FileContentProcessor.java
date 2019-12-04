package org.logan.test.kotlin.basic.cp06.java;

import java.io.File;
import java.util.List;

/**
 * desc:  <br/>
 * time: 2019/12/4 11:40 AM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public interface FileContentProcessor {

	void processContents(File path,
						 byte[] binaryContents,
						 List<String> textContents);

}
