package com.lsl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author shiliang.li
 * @date 2020/3/30
 */
public class MySemaphore {

    public static void main(String[] args) {
        semaphoreMethod();
    }


    private static void semaphoreMethod() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(2);


        System.out.println(semaphore.availablePermits());



        for (int i = 0; i < 10; i++) {
            final int No = i;
            Runnable runnable = () -> {
                try {
                    semaphore.acquire();
                    System.out.println("Accessing:" + No);
                    Thread.sleep(5000);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }

}
