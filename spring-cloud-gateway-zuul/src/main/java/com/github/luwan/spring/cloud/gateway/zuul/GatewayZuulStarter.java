package com.github.luwan.spring.cloud.gateway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author luwan
 * @date 2019/11/11
 */
@SpringBootApplication(scanBasePackages = "com.github.luwan.spring.cloud.gateway.zuul")
@EnableZuulProxy
@EnableEurekaClient
public class GatewayZuulStarter {

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulStarter.class, args);
    }

}
