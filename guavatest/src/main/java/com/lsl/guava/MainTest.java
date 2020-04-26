package com.lsl.guava;

import com.google.common.base.Splitter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.TimeUnit;

/**
 * @author shiliang.li
 * @date 2020/4/14
 */
public class MainTest {
    public static void main(String[] args) {
        MainTest mainTest = new MainTest();
        mainTest.guavaSplit();
    }

    public void cacheTest() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                // 设置缓存的最大容量
                .maximumSize(100)
                // 设置缓存在写入一分钟后失效
                .expireAfterWrite(3, TimeUnit.SECONDS)
                // 设置并发级别为10
                .concurrencyLevel(10)
                // 开启缓存统计
                .recordStats()
                .build();
        // 放入缓存
        cache.put("key", "value");
        // 获取缓存
        String value = cache.getIfPresent("key");
        System.out.println(value);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String key = cache.getIfPresent("key");
        System.out.println(key);
    }

    public void cacheLoadTest() {
        LoadingCache<String, String> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build(
                        new CacheLoader<String, String>() {
                            @Override
                            public String load(String key) {
                                System.out.println("load key ：" + key);
                                return key + " ：value";
                            }
                        }
                );
        System.out.println(graphs.getUnchecked("hello"));
        System.out.println(graphs.getUnchecked("hello"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(graphs.getUnchecked("hello"));
    }

    public void guavaSplit() {
        Iterable<String> split = Splitter.on(",").omitEmptyStrings().split("subCategory,aa,bb");
        System.out.println(split);
    }
}
