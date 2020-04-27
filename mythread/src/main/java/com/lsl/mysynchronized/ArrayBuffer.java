package com.lsl.mysynchronized;

/**
 * @author shiliang.li
 * @date 2020/4/27
 */
public class ArrayBuffer {
    // 产品的数量
    public int pnum=0;

    /**
     * 增加产品数量
     * @param value
     * @throws InterruptedException
     */
    public synchronized void put(int value)throws InterruptedException{
        System.out.println("生产了一件产品 当前库存：" + ++pnum);
    }

    /**
     * 减少产品数量
     * @return
     * @throws InterruptedException
     */
    public synchronized int get() throws InterruptedException{

        if(pnum==0){
            System.out.println("没有货了，停止销售。");
            wait();
            return 0;
        }

        this.notify();
        System.out.print("正在销售了一件产品");
        System.out.println("销售了一件产品...当前库存：" + --pnum);
        return 1;
    }
}
