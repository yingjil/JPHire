package com.example.demo.controller;

import com.example.demo.service.KeyWordSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/search", produces = "application/json;charset=UTF-8")
public class KeyWordSearchController {
    @Value("${url.baidu.search}")
    private String baiduUrl;

    @Autowired
    private KeyWordSearchService keyWordSearchService;

    @RequestMapping("/baidu")
    public String searchByKeyWork(@RequestParam(value = "keyWord") String keyWord) throws Exception {
        return keyWordSearchService.searchByKeyWord(baiduUrl + keyWord);
    }
}
