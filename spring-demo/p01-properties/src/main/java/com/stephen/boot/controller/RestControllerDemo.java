package com.stephen.boot.controller;

import com.alibaba.fastjson.JSON;
import com.stephen.boot.config.PropertyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/21 14:50
 * @Desc：
 */

@RestController
public class RestControllerDemo {
    @Autowired
    private Environment environment;

    @Autowired
    private PropertyBean propertyBean;


    /**
     * rest接口
     * @return
     */
    @GetMapping(path="showtime")
    public String showtime() {
        Map<String, String> result = new HashMap<>(4);
        result.put("propertyBean", propertyBean.toString());
        result.put("uuid", propertyBean.getUid().toString());
        result.put("key", propertyBean.getKey().toString());
        result.put("value", propertyBean.getValue().toString());

        System.out.println("------101-----" + result);
        return JSON.toJSONString(result);
    }
}
