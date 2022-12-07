package com.tawe.dcs.web.controller;

import com.tawe.dcs.starter.base.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * DcsWebApplication
 *
 * @Author tangwei
 * @Date 2022/11/6 17:06
 */
@SpringBootApplication
public class DcsWebApplication implements CommandLineRunner {

    @Autowired
    private IHelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(DcsWebApplication.class);
    }

    @Override
    public void run(String... args) {
        System.out.println(helloService.toString());
    }
}
