package com.stephen.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/21 16:45
 * @Desc：
 */

@Data
@Component
@ConfigurationProperties(prefix = "biz")
public class BizConfig {
    private Long refresh;
    private String key;
}
