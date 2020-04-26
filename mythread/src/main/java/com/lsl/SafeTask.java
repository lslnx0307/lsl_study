package com.lsl;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author shiliang.li
 * @date 2020/3/26
 */
public class SafeTask implements Runnable {

   private static ThreadLocal<Date> dateThreadLocal = new ThreadLocal<Date>(){
       @Override
       protected Date initialValue() {
           return new Date();
       }
   };

    @Override
    public void run() {
        System.out.printf("Starting Thread: %s : %s\n",Thread.currentThread().getId(),dateThreadLocal.get());
        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",Thread.currentThread().getId(),dateThreadLocal.get());
    }
}
