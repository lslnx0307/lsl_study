package com.lsl.mysynchronized;

/**
 * 1.synchronized 修饰方法，属于对象锁 同一个实例会被阻塞
 * @author shiliang.li
 * @date 2020/4/27
 */
public class WexPay implements IPay{

    public static final Object lsl = new Object();

    @Override
    public void pay() {
        synchronized (lsl) {
            System.out.println(Thread.currentThread().getName() + "==》pay success");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*@Override
    public synchronized void pay() {
        System.out.println(Thread.currentThread().getName() + "==》pay success");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }*/
}
