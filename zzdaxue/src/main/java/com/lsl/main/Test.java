package com.lsl.main;

/**
 * @author shiliang.li
 * @date 2020/4/8
 */
public class Test {

    public static void main(String[] args) {
        Type[] values = Type.values();
        for (Type value : values) {
            System.out.println(value.getTypeName());
        }
    }
}
