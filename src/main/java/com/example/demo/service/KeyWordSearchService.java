package com.example.demo.service;

import com.example.demo.constant.BusiErrorConstant;
import com.example.demo.exception.BusinessException;
import com.example.demo.util.WebPageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class KeyWordSearchService {
    private static Logger logger = LoggerFactory.getLogger(KeyWordSearchService.class);

    public String searchByKeyWord(String url)throws BusinessException {
        String result = "";
        try {
            result = WebPageUtil.firstNonAdResult(url);
        } catch (Exception e) {
            logger.error("KeyWordSearchService searchByKeyWord fail.url:{}",url,e);
            throw BusiErrorConstant.SEARCH_FAILED;
        }
        return result;
    }
}
