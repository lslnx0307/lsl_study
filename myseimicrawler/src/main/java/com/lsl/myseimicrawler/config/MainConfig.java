package com.lsl.myseimicrawler.config;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.spring.SpringGeccoEngine;
import com.geccocrawler.gecco.spring.SpringPipelineFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author shiliang.li
 * @date 2020/3/31
 */
@Configuration
@ComponentScan(basePackages = "com.lsl.myseimicrawler")
public class MainConfig {

    public static final String URL = "https://www.nike.com/cn/t/joyride-run-2-pod-%E7%94%B7%E5%AD%90%E8%B7%91%E6%AD%A5%E9%9E%8B-Q68mRl/CU3008-071";

    @Bean
    public SpringGeccoEngine springGeccoEngine() {
        return new SpringGeccoEngine() {
            @Override
            public void init() {
                GeccoEngine.create()
                        .classpath("com.lsl.myseimicrawler.spider")
                        .pipelineFactory(springPipelineFactory)
                        .start(URL)
                        .interval(3000)
                        .loop(true)
                        .start();
            }
        };
    }
    @Bean
    public SpringPipelineFactory springPipelineFactory() {
        return new SpringPipelineFactory();
    }
}
