package com.lsl;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author shiliang.li
 * @date 2020/3/26
 */
public class UnsafeTask implements Runnable{

    private Date count;

    @Override
    public void run() {
        count = new Date();
        System.out.printf("Starting Thread: %s : %s\n",Thread. currentThread().getId(),count);

        try {
            TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread. currentThread().getId(),count);
    }
}
