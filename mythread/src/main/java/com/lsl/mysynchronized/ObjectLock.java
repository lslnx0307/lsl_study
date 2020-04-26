package com.lsl.mysynchronized;

/**
 * synchronized 三种方式
 * 1.锁this
 * 2.锁方法
 * 3.锁变量
 * @author shiliang.li
 * @date 2020/4/8
 */
public class ObjectLock {

    private Object lock = new Object();

    public void lockObjectFiled() throws InterruptedException {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10 * 1000);
        }
    }

    public void lockThis() throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10 * 1000);
        }
    }

    public synchronized void methodLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10 * 1000);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(new ObjectLockWorker());
            t1.setName("kite-" + i);
            t1.start();
        }
    }


    static class ObjectLockWorker implements Runnable {

        @Override
        public void run() {
            ObjectLock lock = new ObjectLock();
            try {
//                lock.lockObjectFiled();
//                lock.lockThis();
                lock.methodLock();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
