package com.lsl.pachong;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * @author shiliang.li
 * @date 2020/4/1
 */
public class MyHtmlUnitDriver {

    public static final String URL = "https://www.nike.com/cn/t/joyride-run-2-pod-%E7%94%B7%E5%AD%90%E8%B7%91%E6%AD%A5%E9%9E%8B-Q68mRl/CU3008-071";

    public static void main(String[] args) {
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
        ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        driver.get(URL);
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
    }
}
