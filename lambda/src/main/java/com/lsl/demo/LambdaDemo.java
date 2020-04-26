package com.lsl.demo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @USER: shiliang.li
 * @DATE: 2019/11/22 17:24
 * @describe //TODO
 **/

public class LambdaDemo {

    private List<Integer> list = new ArrayList<>();

    @Before
    public void init() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        for (int i : numbers) {
            list.add(i);
        }
    }

    /**
     * 判断真假 predicate 断言
     * or      ||
     * and     &&
     * negate  negate() 取反
     * test   执行
     */
    @Test
    public void predicate() {
        //声明一个判断的接口
        Predicate<Integer> predicate = x -> x > 10;
        Predicate<Integer> and = x -> x < 14;
        Predicate<Integer> negate = x -> x % 2 == 0;
        System.out.println(predicate.test(4));
        System.out.println(list.stream().filter(predicate.and(and).and(negate.negate())).collect(Collectors.toList()));

    }

    /**
     * Function<T,R>.apply  把t转换成r
     * Function<T,R>.andThen 先执行调用者，在执行参数
     * Function<T,R>.compose 先执行参数 再执行调用者
     */
    @Test
    public void function() {
        Function<Integer, Integer> function1 = x -> x * x;
        System.out.println(function1.apply(10));
        Function<Integer, Integer> function2 = x -> x * 2;
        System.out.println(function2.andThen(function1).apply(10));
        System.out.println(function2.compose(function1).apply(10));
    }

    /**
     * 一元操作 逻辑非(!)
     */
    @Test
    public void UnaryOperator() {
        UnaryOperator<Boolean> unaryOperator = x -> !x;
        System.out.println(unaryOperator.apply(true));
    }


    /**
     * 两元操作
     * binaryOperator extend function
     */
    @Test
    public void binaryOperator() {
        BinaryOperator<Integer> binaryOperator = (x, y) -> x * y;
        System.out.println(binaryOperator.apply(2, 3));
    }

    /**
     * Stream 转list
     */
    @Test
    public void toList() {
        List<Student> studentList = Stream.of(new Student("路飞", 22),
                new Student("红发", 40),
                new Student("白胡子", 50)).collect(Collectors.toList());
        System.out.println(studentList);
    }

    /**
     * stream.map 转换
     */
    @Test
    public void map() {
        List<Student> studentList = Stream.of(new Student("路飞", 22),
                new Student("红发", 40),
                new Student("白胡子", 50), new Student("白胡子", 51)).collect(Collectors.toList());
        List<String> nameLists = studentList.stream().map(s -> s.getName()).collect(Collectors.toList());
        System.out.println(nameLists);
        List<String> filterList = studentList.stream()
                .map(s -> s.getName()).filter(e -> e.equals("红发")).collect(Collectors.toList());
        System.out.println(filterList);

//        System.out.println(studentList.stream().collect(Collectors.toMap(Student::getName, e ->e)));

        System.out.println(studentList.stream()
                .collect(Collectors.toMap(Student::getName, e -> e, (v1, v2) -> v2)));


    }

}
