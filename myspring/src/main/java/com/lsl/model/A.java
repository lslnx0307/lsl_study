package com.lsl.model;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl.model
 * @Description: :
 * @time 2020/3/18 16:12
 */
public class A {

    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public A() {
    }

    public A(B b) {
        this.b = b;
    }
}
