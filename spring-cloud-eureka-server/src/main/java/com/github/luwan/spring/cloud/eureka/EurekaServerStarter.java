package com.github.luwan.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Luwan
 * @date 2019/10/28
 */
@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
public class EurekaServerStarter {

  public static void main(String[] args) {
    SpringApplication.run(EurekaServerStarter.class, args);
  }
}
