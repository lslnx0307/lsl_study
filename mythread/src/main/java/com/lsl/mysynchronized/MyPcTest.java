package com.lsl.mysynchronized;

/**
 * @author shiliang.li
 * @date 2020/4/27
 */
public class MyPcTest {

    public static void main(String args[]) throws InterruptedException {
        ArrayBuffer c = new ArrayBuffer();
        Producer p = new Producer(c);
        p.setName("生产");
        Consumer consumer = new Consumer(c);
        consumer.setName("销售");
        p.start();
        consumer.start();

    }
}
