package com.lsl;

import java.util.concurrent.ThreadFactory;

/**
 * @author shiliang.li
 * @date 2020/3/26
 */
public class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}
