package org.logan.test.kotlin.basic.cp06

import org.logan.test.kotlin.basic.cp06.java.DataParser
import org.logan.test.kotlin.java.Person

/**
 * desc: 平台类型集合 <br/>
 * time: 2019/12/4 11:49 AM <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class PersonParser : DataParser<Person> {

    override fun parseData(
        input: String,
        output: MutableList<Person>,
        errors: MutableList<String?> //元素可空
    ) {
        // ...
    }

}