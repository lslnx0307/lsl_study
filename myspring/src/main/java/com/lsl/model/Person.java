package com.lsl.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl.model
 * @Description: :
 * @time 2020/3/13 17:51
 */
public class Person {

    private static String personName;

    @Value("#{person.name}")
    public void setPersonName(String personName) {
        Person.personName = personName;
    }

    public static void speak() {
        System.out.println("我的名字：" + personName);
    }
}
