package com.lsl.mysynchronized;

/**
 * @author shiliang.li
 * @date 2020/4/27
 */
public class Consumer extends Thread {
    private ArrayBuffer c;

    public Consumer(ArrayBuffer cc){
        this.c=cc;

    }

    public void run(){
        int i;
        for(i=0;true;i++){
            try {

                Thread.sleep(300); //销售速度
                c.get();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
