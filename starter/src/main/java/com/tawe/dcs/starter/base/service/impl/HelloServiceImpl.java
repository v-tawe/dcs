package com.tawe.dcs.starter.base.service.impl;

import com.tawe.dcs.starter.base.service.IHelloService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.stereotype.Service;

/**
 * HelloServiceImpl
 *
 * @Author tangwei
 * @Date 2022/11/6 15:42
 */
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class HelloServiceImpl implements IHelloService {
    private String pro1;
    private String pro2;

    @Override
    public String sayHello() {
        return "Hello";
    }

    @Override
    public void setPro1(String pro1) {
        this.pro1 = pro1;
    }

    @Override
    public void setPro2(String pro2) {
        this.pro2 = pro2;
    }
}
