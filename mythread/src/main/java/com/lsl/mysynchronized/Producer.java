package com.lsl.mysynchronized;

/**
 * @author shiliang.li
 * @date 2020/4/27
 */
public class Producer extends Thread{

    private ArrayBuffer c;
    public Producer(ArrayBuffer cc){
        this.c=cc;
    }

    public void run() {
        int i;
        for(i=0;true;i++){
            try {
                Thread.sleep(500); //生产速度
                c.put(i);
                if(c.pnum >= 20) //货源到达一定数时 通知开始销售
                    synchronized (c) {
                        c.notify();
                    }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
