package com.lsl.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author shiliang.li
 * @date 2020/4/8
 */
public class Study {

    public static final String LOGIN_URL = "http://vls3.zzu.edu.cn/default.htm";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/jm009218/Desktop/chromedriver.exe");
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get(LOGIN_URL);
        WebElement element = webDriver.findElement(By.cssSelector("body > form > div > table > tbody > tr:nth-child(3) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(1) > td > a > font"));
        if ("学生登录".equals(element.getText())) {
            element.click();
        }
        WebElement userName = webDriver.findElement(By.name("uid"));
        WebElement passWord = webDriver.findElement(By.name("pw"));
        WebElement loginBtn = webDriver.findElement(By.name("B1"));
        userName.sendKeys("19117706090");
        passWord.sendKeys("19920305");
        loginBtn.submit();

        //进入系统
        webDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        WebElement goIndex = webDriver.findElement(By.name("gointo"));
        System.out.println(goIndex.getAttribute("value"));
        String onClickStr = goIndex.getAttribute("onclick");
        webDriver.executeScript(onClickStr);
        WebElement mytop = webDriver.findElement(By.name("mytop"));
        String sessionId = mytop.getAttribute("src");
        int start = sessionId.lastIndexOf("ptopid=");
        String sessionSub = sessionId.substring(start + 7, sessionId.length());
        System.out.println(sessionSub);
        System.out.println( sessionSub + "&amp;keid=0006");
        webDriver.get(sessionSub + "&amp;keid=0006");
//        List<WebElement> elements = webDriver.findElements(By.xpath("/html/body/form/div/table/tbody/tr[2]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/p"));
//        for (WebElement webElement : elements) {
//            System.out.println(webElement.getText());
//        }

    }
}
