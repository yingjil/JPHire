package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The demo class for JPHire.
 *
 * @author zhangxiaozhi
 * @version 1.0, 2019/5/5
 * @since demo 1.0.0
 */
@RestController
public class DemoController {

    @Resource
    private DemoService demoService;

    @GetMapping(value = "/")
    public String mainPage() {
        return demoService.demo();
    }
}
