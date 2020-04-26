package com.lsl.pachong;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author shiliang.li
 * @date 2020/3/31
 */
public class MyChrome {

    public static final String LIULANQI = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
    public static final String URL = "https://www.nike.com/cn/t/joyride-run-2-pod-%E7%94%B7%E5%AD%90%E8%B7%91%E6%AD%A5%E9%9E%8B-Q68mRl/CU3008-071";

    public static void main(String[] args) {
        WebDriver driver;

        /**
         * webDriver在调用Friefox浏览器时，是使用安装时的默认文件路径，如果使用量自定义的安装路径，
         * 则可能导致程序无法找到firefox.exe导致报错，因此需要执行以下代码，设置firefox的路径。
         */
//        System.setProperty("webdriver.firefox.bin", LIULANQI);

        driver=new FirefoxDriver();
        //打开百度首页
        driver.get(URL);

    }
}
