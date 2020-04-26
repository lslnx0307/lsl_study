package com.lsl;

/**
 * @author shiliang.li
 * @date 2020/3/27
 */
public class MyVoliateDemo {

    private static int count = 10;

    private static Object object = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {a();b();});
        t1.start();
    }

    private static   void a() {
        synchronized (object) {
            count = 11;
        }
    }

    private static synchronized void b() {}
}
