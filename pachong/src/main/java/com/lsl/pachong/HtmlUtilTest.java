package com.lsl.pachong;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author shiliang.li
 * @date 2020/3/31
 */
public class HtmlUtilTest {

//    public static final String URL = "https://www.nike.com/cn/t/joyride-run-2-pod-%E7%94%B7%E5%AD%90%E8%B7%91%E6%AD%A5%E9%9E%8B-Q68mRl/CU3008-071";

    public static final String URL = "file:///C:/Users/jm009218/Desktop/index.html";

    public static void main(String[] args) throws IOException, InterruptedException {
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //支持JavaScript
        webClient.getOptions().setJavaScriptEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setTimeout(50000);

        webClient.getOptions().setDoNotTrackEnabled(true);
        HtmlPage rootPage = webClient.getPage(URL);
        //设置一个运行JavaScript的时间
        webClient.waitForBackgroundJavaScript(30000);
        webClient.setJavaScriptTimeout(30000);
        rootPage.executeJavaScript("window.scrollTo(0,document.body.scrollHeight)");
        String html = rootPage.asXml();

        Document document = Jsoup.parse(html);
        System.out.println(document.outerHtml());
        FileWriter fileWriter = new FileWriter("C:\\Users\\jm009218\\Desktop\\html.txt", false);
        fileWriter.write(html);
        fileWriter.flush();
        fileWriter.close();
        webClient.close();

    }




}
