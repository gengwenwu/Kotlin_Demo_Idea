package org.logan.test.kotlin.basic.cp05.java;

/**
 * desc: java样例代码 <br/>
 * time: 2019-09-19 11:20 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class ToolJobCp05 {

    public static void postponeComputation(int dealy, Runnable computation) {
        computation.run();
    }

}
