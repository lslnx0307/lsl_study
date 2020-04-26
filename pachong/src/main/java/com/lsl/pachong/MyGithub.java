package com.lsl.pachong;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.Html;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * @author shiliang.li
 * @date 2020/3/30
 */
@Gecco(matchUrl = "https://www.nike.com/cn/", pipelines="consolePipeline")
public class MyGithub implements HtmlBean {


    private static final long serialVersionUID = -7127412585200687225L;


    @Html
    @HtmlField(cssPath=".ncss-container fixed-fluid css-82wz06 css-1bhwifz")
    private List<String> readme;

    public List<String> getReadme() {
        return readme;
    }

    public void setReadme(List<String> readme) {
        this.readme = readme;
    }

    public static void main(String[] args) {
        GeccoEngine.create()
                //工程的包路径
                .classpath("com.lsl.pachong")
                //开始抓取的页面地址
                .start("https://www.nike.com/cn/t/joyride-run-2-pod-%E7%94%B7%E5%AD%90%E8%B7%91%E6%AD%A5%E9%9E%8B-Q68mRl/CU3008-071")
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(2000)
                //循环抓取
                .loop(true)
                //使用pc端userAgent
                .mobile(false)
                //非阻塞方式运行
                .start();
    }
}
