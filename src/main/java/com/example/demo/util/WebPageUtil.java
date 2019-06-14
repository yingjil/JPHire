package com.example.demo.util;

import com.example.demo.constant.BusiConstant;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WebPageUtil {

    private static Logger logger = LoggerFactory.getLogger(WebPageUtil.class);
    /**
     * fetch web content
     *
     * @param url
     * @return Element
     * @throws IOException
     */
    public static Element fetcher(String url) {
        Connection conn = Jsoup.connect(url);
        Element ele = null;
        try {
            Document doc = conn.get();
            ele= doc.getElementById("content_left");
        }catch(IOException e){
            logger.error("WebPageUtil fetcher failed.url:{}",url,e);
        }
        return ele;
    }

    /**
     * 1st non-Ad result
     *
     * @return
     */
    public static String firstNonAdResult(String url) {
        Element ele = fetcher(url);
        //fetch 1st non-Ad div
        Elements elements = ele.getElementsByAttributeValueStarting("class", "result");
        if(elements == null) return BusiConstant.VALID_RESULT_NOT_FOUND;
        Node noAdDivRoot = elements.get(0);
        NodeIterable iterator = new NodeIterable(noAdDivRoot);
        for (Node node : iterator) {
            if (node instanceof Element) {
                if (((Element) node).tagName().equals("a")) {
                    String result = String.format("first search item is:%s  link:%s",((Element) node).text(),node.attr("href"));
                    return result;
                }
            }
        }
        return BusiConstant.VALID_RESULT_NOT_FOUND;
    }
}
