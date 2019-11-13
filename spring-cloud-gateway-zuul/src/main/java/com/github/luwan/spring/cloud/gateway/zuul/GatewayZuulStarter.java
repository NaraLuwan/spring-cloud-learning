package com.github.luwan.spring.cloud.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author luwan
 * @date 2019/11/11
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@ComponentScan(value = {"com.github.luwan.spring.cloud.gateway.zuul.filter"})
public class GatewayZuulStarter {

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulStarter.class, args);
    }

}
