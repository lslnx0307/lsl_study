package com.lsl;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl
 * @Description: :
 * @time 2020/3/19 9:33
 */
public class MyThreadDeadLock {

    private static String resource_a = "A";
    private static String resource_b = "B";

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (resource_a) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getId());
                    Thread.sleep(1000);
                    synchronized (resource_b) {
                        System.out.println("thread a");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (resource_b) {
                System.out.println(Thread.currentThread().getName() + ": " + Thread.currentThread().getId());
                synchronized (resource_a){
                    System.out.println("thread_b");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
