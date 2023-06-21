package com.stephen.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/21 14:55
 * @Desc：prop属性Bean
 */

@Data
@Component
@ConfigurationProperties(prefix = "app.property")
public class PropertyBean {
    private String uid;
    private Long key;
    private String value;
}