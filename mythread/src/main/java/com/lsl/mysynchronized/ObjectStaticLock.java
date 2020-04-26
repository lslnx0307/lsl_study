package com.lsl.mysynchronized;

/**
 * 静态变量锁
 * @author shiliang.li
 * @date 2020/4/8
 */
public class ObjectStaticLock {

    private static Object lock = new Object();

    /**
     * 锁静态变量
     * @throws InterruptedException
     */
    public void lockStaticObjectFile() throws InterruptedException {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10 * 1000);
        }
    }

    /**
     * 静态方法锁
     * @throws InterruptedException
     */
    public static synchronized void lockStaticMethod() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(10 * 1000);
    }

    /**
     * 锁class类
     * @throws InterruptedException
     */
    public void lockClass() throws InterruptedException {
        synchronized (ObjectStaticLock.class) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(10 * 1000);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(new ObjectStaticLockWoker());
            t1.setName("lsl-" + i);
            t1.start();
        }
    }


    static class ObjectStaticLockWoker implements Runnable {
        @Override
        public void run() {
            try {
                ObjectStaticLock staticLock = new ObjectStaticLock();
                System.out.println("staticLock hashcode => " + staticLock.hashCode());
                staticLock.lockStaticObjectFile();
//                ObjectStaticLock.lockStaticMethod();
//                staticLock.lockClass();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
