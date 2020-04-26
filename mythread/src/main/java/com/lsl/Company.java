package com.lsl;

import java.math.BigDecimal;

/**
 * @author shiliang.li
 * @date 2020/3/26
 */
public class Company implements Runnable{

    private Acount acount;

    public Company(Acount acount) {
        this.acount = acount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            acount.reduceAmount(BigDecimal.ONE);
        }
    }
}
