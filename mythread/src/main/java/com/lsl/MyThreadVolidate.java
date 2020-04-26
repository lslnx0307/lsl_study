package com.lsl;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl
 * @Description: :
 * @time 2020/3/18 14:48
 */
public class MyThreadVolidate {

    private volatile boolean flag = false;
    static Object o = new Object();

    private  void load() {
        this.flag = true;
        String threadname = Thread.currentThread().getName();
        System.out.println("线程："+threadname+":修改共享变量initFlag");
    }

    private  void refesh() {
        String threadname = Thread.currentThread().getName();
        while (!flag){
//            synchronized (o) {
//
//            }
        }
        System.out.println("线程："+threadname+"当前线程嗅探到initFlag的状态的改变");
    }

    public static void main(String[] args) {
        MyThreadVolidate myThreadVolidate = new MyThreadVolidate();
        Thread t1 = new Thread(() -> {
            myThreadVolidate.refesh();
        });

        Thread t2 = new Thread(() -> {
            myThreadVolidate.load();
        });
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
