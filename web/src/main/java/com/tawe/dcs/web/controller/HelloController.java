package com.tawe.dcs.web.controller;

import com.tawe.dcs.starter.base.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * HelloController
 *
 * @Author tangwei
 * @Date 2022/11/6 15:59
 */
@Controller
public class HelloController {
    @Autowired
    private IHelloService helloService;

    public String hello() {
        return helloService.sayHello();
    }
}
