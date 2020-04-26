package com.lsl.myseimicrawler.service;

import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;
import com.lsl.myseimicrawler.spider.NikeSpider;
import org.springframework.stereotype.Service;

/**
 * @author shiliang.li
 * @date 2020/3/31
 */
@Service("myCustomerPipeline")
public class MyCustomerPipeline implements Pipeline<SpiderBean> {


    @Override
    public void process(SpiderBean bean) {
        NikeSpider nikeSpider = (NikeSpider) bean;
        System.out.println("自定义输出：" + nikeSpider.getContext());
    }
}
