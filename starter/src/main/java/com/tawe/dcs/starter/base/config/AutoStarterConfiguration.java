package com.tawe.dcs.starter.base.config;

import com.tawe.dcs.starter.base.service.IHelloService;
import com.tawe.dcs.starter.base.service.impl.HelloServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * AutoConfiguration
 *
 * @Author tangwei
 * @Date 2022/11/6 15:44
 */
@Configuration
@EnableConfigurationProperties({AutoStarterProperties.class})
@ComponentScan("com.tawe.dcs.starter.base.service")
public class AutoStarterConfiguration {

    @Autowired
    private AutoStarterProperties autoStarterProperties;

    @Bean
    @ConditionalOnMissingBean
    public IHelloService getHelloService() {
        return new HelloServiceImpl(autoStarterProperties.getPro1(), autoStarterProperties.getPro2());
    }
}
