package com.lsl.mysynchronized;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shiliang.li
 * @date 2020/4/8
 */
public class MyObject {

    private static Object object = new Object();

    public static void main(String[] args) {


        List<String> strings = new LinkedList<String>();
        for (int i = 0; i < 10; i++) {
            strings.add(i + ",");
        }

        System.out.println(strings.size());

        StringBuffer stringBuffer = new StringBuffer("1,2,3,4");
        System.out.println(stringBuffer.subSequence(0, stringBuffer.length() >= 15 ? 15 : stringBuffer.length()).toString());

    }
}
