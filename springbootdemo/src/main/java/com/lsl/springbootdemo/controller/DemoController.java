package com.lsl.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author shiliang.li
 * @date 2020/3/31
 */
@Controller
public class DemoController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
