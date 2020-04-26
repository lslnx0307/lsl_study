package com.lsl.pachong;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.spider.SpiderBean;

/**
 * @author shiliang.li
 * @date 2020/3/31
 */
@PipelineName("myCustomerPipeline")
public class MyCustomerPipeline implements Pipeline<SpiderBean> {


    @Override
    public void process(SpiderBean bean) {
        NikeSpider nikeSpider = (NikeSpider) bean;
        System.out.println("自定义输出：" + nikeSpider.getContext());
    }
}
