package com.lsl;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shiliang.li
 * @date 2020/3/25
 */
public class MyReentrantLock {


    private int count = 0;

    private ReentrantLock lock = new ReentrantLock();

    public void add() {
        lock.lock();
        try {
            count++;
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    public static void main(String[] args) {
        MyReentrantLock  myReentrantLock = new MyReentrantLock();
        for (int i = 0; i < 10 ; i++) {
            new Thread(() ->{
                for (int j = 0; j < 1000; j++) {
                    myReentrantLock.add();
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(myReentrantLock.count);
    }
}
