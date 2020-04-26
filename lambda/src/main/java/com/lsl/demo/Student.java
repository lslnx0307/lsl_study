package com.lsl.demo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @USER: shiliang.li
 * @DATE: 2019/11/25 14:50
 * @describe //TODO
 **/

@Data
@AllArgsConstructor
public class Student {

    private String name;

    private Integer age;

    public static void printArray(Object[] objs){}

    public static <T extends Student> void printArray(T[] objs){}

}
