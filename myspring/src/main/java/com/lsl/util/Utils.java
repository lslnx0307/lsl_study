package com.lsl.util;

import com.lsl.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl.util
 * @Description: :
 * @time 2020/3/17 16:09
 */
public class Utils {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring.xml");

        System.out.println(1234);
    }

    private static void handleList(List<Student> list) {
        list = new ArrayList<Student>();
        list.add(new Student("lisi"));
        list.add(new Student("zhaoliu"));
        list.add(new Student("wangwu"));
    }
}
