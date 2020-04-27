package com.lsl;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shiliang.li
 * @date 2020/4/27
 */
public class ThreadWaitDemo {

    public static final AtomicInteger count = new AtomicInteger(0);
    public static final Object look = new Object();

    public static boolean hasRun = true;

    static class A implements Runnable {

        @Override
        public void run() {
            synchronized (look) {
                if(hasRun) {
                    try {
                        look.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + hasRun);
                hasRun = true;
                look.notify();

            }
        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            synchronized (look) {
                if(!hasRun) {
                    try {
                        look.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + hasRun);
                hasRun = false;
                look.notify();
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new A());
        Thread thread1 = new Thread(new B());
        thread.setName("A");
        thread1.setName("B");
        thread.start();
        thread1.start();
    }
}
