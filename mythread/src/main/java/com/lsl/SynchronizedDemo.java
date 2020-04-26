package com.lsl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiliang.li
 * @date 2020/3/25
 */
public class SynchronizedDemo {

    public static void main(String[] args) {
        DataString dataString = new DataString();
        new Thread(()->{
            dataString.add(Thread.currentThread());
        }).start();
        new Thread(()->{
            dataString.add(Thread.currentThread());
        }).start();
    }

    static class DataString {
        List<String> data = new ArrayList<>();

        public synchronized void add(Thread thread) {
            for (int i = 0; i < 5 ; i++) {
                System.out.println(thread.getName() + "在插入数据");
                data.add("abc");
            }

        }
    }
}
