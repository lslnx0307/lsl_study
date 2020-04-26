package com.lsl;

import java.util.UUID;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl
 * @Description: :
 * @time 2020/3/18 14:42
 */
public class MyThread {
    private int count = 0;

    public synchronized void add() {
        count++;
    }

    public static void main(String[] args) {
//        MyThread thread = new MyThread();
//        for (int i = 0; i < 10 ; i++) {
//            new Thread(()->{
//                for (int j = 0; j < 1000; j++) {
//                    thread.add();
//                }
//            }).start();
//        }
//
//
//        while (Thread.activeCount()>1) {
//            System.out.println(Thread.currentThread().getName());
//            Thread.yield();
//        }
//
//        System.out.println(thread.count);

        System.out.println(UUID.randomUUID());

        int i = 0;
        for (;;) {
            i++;
            if (i == 10) {
                break;
            }
            System.out.println("这是第" + i +"个数");
        }
    }

}
