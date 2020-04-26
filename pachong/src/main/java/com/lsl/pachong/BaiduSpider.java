package com.lsl.pachong;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * @author shiliang.li
 * @date 2020/3/30
 */
@Gecco(pipelines = "consolePipeline")
public class BaiduSpider implements HtmlBean {

    private static final long serialVersionUID = -8870768223740844229L;

    @Request
    private HttpRequest request;

    @HtmlField(cssPath="body")
    private String body;

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public static void main(String[] args) {
        GeccoEngine.create()
                .classpath("com.lsl.pachong")
                .start("https://www.baidu.com/")
                .interval(2000)
                .start();
    }
}
