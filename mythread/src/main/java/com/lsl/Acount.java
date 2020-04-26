package com.lsl;

import java.math.BigDecimal;

/**
 * @author shiliang.li
 * @date 2020/3/26
 */
public class Acount {

    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public synchronized void addAmount(BigDecimal amount) {
        BigDecimal temp = balance;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp = temp.add(amount);
        balance = temp;
    }

    public synchronized void reduceAmount(BigDecimal amount) {
        BigDecimal temp = balance;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        temp = temp.subtract(amount);
        balance = temp;
    }


}
