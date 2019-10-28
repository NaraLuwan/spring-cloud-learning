package com.github.luwan.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Luwan
 * @date 2019/10/28
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableAdminServer
public class ProducerApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplicationStarter.class, args);
	}
}
