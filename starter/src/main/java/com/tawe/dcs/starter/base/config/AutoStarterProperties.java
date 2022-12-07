package com.tawe.dcs.starter.base.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * AutoStarterProperties
 *
 * @Author tangwei
 * @Date 2022/11/6 16:05
 */
@ConfigurationProperties("auto-starter")
@Data
public class AutoStarterProperties {
    private String pro1;
    private String pro2;
}
