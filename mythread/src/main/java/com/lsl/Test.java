package com.lsl;

import java.util.concurrent.locks.LockSupport;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 小学生
 * @Date 2020/4/19 09:15
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        int i = 1;
        for (;;) {
            i++;

            if( i == 100) {
                LockSupport.park();
            }

            System.out.println(i);
        }


    }
}
