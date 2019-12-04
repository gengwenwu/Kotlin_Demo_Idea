package org.logan.test.kotlin.basic.cp06

import org.logan.test.kotlin.basic.cp06.java.FileContentProcessor
import java.io.File

/**
 * desc: 平台类型集合 空问题 <br/>
 *
 * 在实现Java接口，kotlin实现默认均为可空的，根据业务情况决定非空情况。下面参数类型，需要考虑的。
 *  (1)、集合是否可空?
 *  (2)、集合中的元素是否可空?
 *  (3)、你的方法会不会修改集合?
 *
 * time: 2019/12/4 11:43 AM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class FileIndexer : FileContentProcessor {

    override fun processContents( // 实现Java接口，注意 平台类型转换问题。
        path: File, // 非空
        binaryContents: ByteArray?, // 可空
        textContents: List<String>? // 可空
    ) {
        //...
    }

}