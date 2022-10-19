package com.lv.mall.thirdpart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.lv")
public class MallThirdPartApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallThirdPartApplication.class, args);
    }

}
