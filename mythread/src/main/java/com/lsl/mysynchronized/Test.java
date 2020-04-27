package com.lsl.mysynchronized;

/**
 * @author shiliang.li
 * @date 2020/4/27
 */
public class Test {

    public static void main(String[] args) {
//        MyRunnable myRunnable = new MyRunnable(new WexPay());
//        //new MyRunnable(new WexPay())
//        for (int i = 0; i < 5 ; i++) {
//            new Thread(new MyRunnable(new WexPay())).start();
//        }
        WexPay wexPay = new WexPay();
        WexPay wexPay1 = new WexPay();
        WexPay wexPay2 = new WexPay();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wexPay.pay();
    }

    static class MyRunnable implements Runnable {

        private IPay iPay;

        public MyRunnable(IPay iPay) {
            this.iPay = iPay;
        }

        @Override
        public void run() {
            iPay.pay();
        }
    }
}
