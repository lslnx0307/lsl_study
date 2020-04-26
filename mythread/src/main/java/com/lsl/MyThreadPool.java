package com.lsl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shiliang.li
 * @date 2020/3/27
 */
public class MyThreadPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        int i = ((ThreadPoolExecutor) executorService).prestartAllCoreThreads();

        while (true) {
            System.out.println(123);
        }
    }
}
