package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * The demo class for JPHire.
 *
 * @author zhangxiaozhi
 * @version 1.0, 2019/5/5
 * @since demo 1.0.0
 */
@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Value("${demo.author.name}")
    private String name;

    @Value("${demo.author.age}")
    private String age;

    @RequestMapping(value = "/report", method = RequestMethod.GET)
    public String demo() {
        return "This is a demo, the author is " + name + ", " + age + " years old boy.";
    }
}
