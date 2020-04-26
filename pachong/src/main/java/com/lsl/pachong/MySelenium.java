package com.lsl.pachong;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shiliang.li
 * @date 2020/4/1
 */
public class MySelenium {

    public static final String URL = "https://www.nike.com/cn/t/joyride-run-2-pod-%E7%94%B7%E5%AD%90%E8%B7%91%E6%AD%A5%E9%9E%8B-Q68mRl/CU3008-071";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/lslnx_0307/Desktop/chromedriver");
        ChromeOptions options = new ChromeOptions();
        List<String> op = new ArrayList<>();
        op.add("--start-maximized");
        op.add("--headless");
        options.addArguments(op);
        ChromeDriver chromeDriver = new ChromeDriver(options);
        //设置超时时间
        chromeDriver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
        //打开url
        chromeDriver.get(URL);
        //滚动条置地
        chromeDriver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        chromeDriver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        chromeDriver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(30000);
        String script = (String) chromeDriver.executeScript("return document.documentElement.outerHTML");
        Document document = Jsoup.parse(script);
        Elements select = document.select("div.css-1bhwifz");
        for (Element element : select) {
            System.out.println("lsl_" + element.html());
        }
        //关闭浏览器
        chromeDriver.close();
        //关闭chreomedriver进程
        chromeDriver.quit();

    }

}
