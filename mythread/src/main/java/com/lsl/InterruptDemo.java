package com.lsl;

/**
 * @author shiliang.li
 * @date 2020/3/26
 */
public class InterruptDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("run");
        while (true) {
            if (Thread.interrupted()) {
                System.out.println("abc...");
            }
        }
    }
}
