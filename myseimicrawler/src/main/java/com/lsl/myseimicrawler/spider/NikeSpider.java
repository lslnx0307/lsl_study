package com.lsl.myseimicrawler.spider;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @author shiliang.li
 * @date 2020/3/30
 */

@Gecco(pipelines = "myCustomerPipeline")
public class NikeSpider implements HtmlBean {


    private static final long serialVersionUID = 3062243279285821300L;


    @HtmlField(cssPath = ".css-rfq3p1")
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }


    public static void main(String[] args) {
        GeccoEngine.create()
                .classpath("com.lsl.pachong")
                .loop(true)
                .start("https://www.nike.com/cn/t/joyride-run-2-pod-%E7%94%B7%E5%AD%90%E8%B7%91%E6%AD%A5%E9%9E%8B-Q68mRl/CU3008-071")
                .interval(2000)
                .mobile(false)
                .start();
    }
}
