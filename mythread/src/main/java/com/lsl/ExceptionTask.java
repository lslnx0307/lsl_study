package com.lsl;

/**
 * @author shiliang.li
 * @date 2020/3/26
 */
public class ExceptionTask implements Runnable{


    @Override
    public void run() {
        int ttt = Integer.parseInt("TTT");
        System.out.println("run中报错了，但是我还是执行了");
    }
}
