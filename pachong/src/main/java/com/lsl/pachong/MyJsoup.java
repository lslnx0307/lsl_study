package com.lsl.pachong;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * @author shiliang.li
 * @date 2020/3/31
 */
public class MyJsoup {

    public static final String URL = "http://localhost:8080/index";
    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect(URL).timeout(2000).get();
        Elements elements = doc.getElementsByClass("frontSize");
        for (Element element : elements) {
            System.out.println(element.html());
        }
    }
}
