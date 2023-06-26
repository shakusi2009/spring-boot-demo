package com.stephen.boot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author: Stephen Zhang
 * @Date: 2023/6/21 16:47
 * @Desc：
 */
@Data
@RefreshScope
@Component
public class ValueConfig {
    @Value("${rest.uuid}")
    private String uuid;
}
