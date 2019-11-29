package com.github.luwan.spring.cloud.sleuth.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

/**
 * @author luwan
 * @date 2019/11/29
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class SleuthZipKinStarter {

    public static void main(String[] args) {
        SpringApplication.run(SleuthZipKinStarter.class, args);
    }

}
