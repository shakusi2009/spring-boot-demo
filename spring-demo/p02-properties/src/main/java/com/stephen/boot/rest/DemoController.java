package com.stephen.boot.rest;

import com.alibaba.fastjson.JSONObject;
import com.stephen.boot.config.BizConfig;
import com.stephen.boot.config.ValueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/21 16:54
 * @Desc：
 */
@RestController
public class DemoController {
    @Autowired
    private ContextRefresher contextRefresher;

    @Autowired
    private BizConfig bizConfig;

    @Autowired
    private ValueConfig valueConfig;

    @Value("${rest.uuid}")
    private String uuid;


    /**
     * rest接口
     * @return
     */
    @GetMapping(path="show")
    public String show() {
        JSONObject res = new JSONObject();
        res.put("biz", JSONObject.toJSONString(bizConfig));
        res.put("uuid", valueConfig.getUuid());
        res.put("no-refresh", uuid);
        return res.toJSONString();
    }

    @GetMapping(path = "/refresh")
    public String refresh() {
        new Thread(() -> contextRefresher.refresh()).start();
        return show();
    }

    @EventListener
    public void envListener(EnvironmentChangeEvent event) {
        System.out.println("-------101--------conf change: " + event);
    }
}
