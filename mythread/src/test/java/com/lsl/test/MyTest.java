package com.lsl.test;

import com.lsl.Acount;
import com.lsl.Bank;
import com.lsl.Company;
import com.lsl.ExceptionTask;
import com.lsl.FileSearch;
import com.lsl.InterruptDemo;
import com.lsl.SafeTask;
import com.lsl.UnsafeTask;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * @author shiliang.li
 * @date 2020/3/26
 */
public class MyTest {


    @Test
    public void interruptedTest() throws InterruptedException {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        thread.setPriority(10);
//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Test
    public void fileSearch() {
        Thread thread = new Thread(new FileSearch("C:\\Users\\jm009218\\Desktop", "新建文本文档.html"));
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

    }


    @Test
    public void testException() {
        try {
            int ttt = Integer.parseInt("TTT");
            System.out.println(ttt);
        }catch (NumberFormatException e) {
            e.printStackTrace();
        }


        System.out.println("我报异常了，但是还是走了");
    }

    @Test
    public void exceptionTask() throws InterruptedException {
        ExceptionTask task = new ExceptionTask();
        Thread thread = new Thread(task);
//        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
        thread.join();
        System.out.println("我报异常了，但是还是走了");

    }

    @Test
    public void unsafeTask() {
        UnsafeTask task=new UnsafeTask();
        for (int i=0; i<10; i++){
            Thread thread=new Thread(task);
            thread.start();
            try { TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void safeTask() {
        SafeTask task=new SafeTask();
        for (int i=0; i<10; i++){
            Thread thread=new Thread(task);
            thread.start();
            try { TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void bankTest() {
        Acount acount = new Acount();
        acount.setBalance(new BigDecimal(1000));
        System.out.printf("Account : Initial Balance: %f\n",acount.getBalance());
        Bank bank = new Bank(acount);
        Company company = new Company(acount);
        Thread t1 = new Thread(bank);
        Thread t2 = new Thread(company);

        try {
            t2.start();
            t1.start();
            t2.join();
            t1.join();
            System.out.printf("Account : Final Balance: %f\n",acount.getBalance());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void StringTest() {
        Long startTime = System.currentTimeMillis();
        String str = "about,bed,check,doc,txt,from";
        for (int i = 0; i < 10000; i++) {
            String[] strings = str.split(",", 0);
        }
        long l = System.currentTimeMillis() - startTime;
        System.out.println("耗时：" + l);
        method2(str);
    }



    public void method2(String orgStr) {
        Long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            StringTokenizer tokener = new StringTokenizer(orgStr,",");
            String [] result = new String[tokener .countTokens()];

            int j=0;
            while(tokener. hasMoreTokens ())
            {
                result[j++]=tokener.nextToken();
            }
        }
        long l = System.currentTimeMillis() - startTime;
        System.out.println("耗时：" + l);
    }
}
