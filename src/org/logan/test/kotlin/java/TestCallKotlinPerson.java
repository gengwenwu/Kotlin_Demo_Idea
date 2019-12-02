package org.logan.test.kotlin.java;

import org.logan.test.kotlin.basic.cp02.Person;

/**
 * desc: 调用Kotlin Person <br/>
 * time: 2019-08-22 15:20 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class TestCallKotlinPerson {


    public static void main(String[] args) {

        // 调用Kotlin Person，可与Person.main()做对比
        Person person = new Person("Logan", false);
        System.out.println(person.getName());
        person.setMarried(true);

    }

}
