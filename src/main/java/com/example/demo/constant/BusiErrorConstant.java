package com.example.demo.constant;

import com.example.demo.exception.BusinessException;

public class BusiErrorConstant {
    public static BusinessException SEARCH_FAILED = new BusinessException(1000,"search failed");
}
