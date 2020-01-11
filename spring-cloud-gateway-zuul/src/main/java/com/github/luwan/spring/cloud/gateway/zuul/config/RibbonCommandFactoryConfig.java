package com.github.luwan.spring.cloud.gateway.zuul.config;

import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.cloud.netflix.zuul.filters.route.RestClientRibbonCommandFactory;
import org.springframework.cloud.netflix.zuul.filters.route.apache.HttpClientRibbonCommandFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author luwan
 * @date 2019/11/18
 */
@Configuration
public class RibbonCommandFactoryConfig {

    @Bean
    public HttpClientRibbonCommandFactory ribbonCommandFactory(final SpringClientFactory clientFactory) {
        return new HttpClientRibbonCommandFactory(clientFactory);
    }


    @Bean
    @Primary
    public RestClientRibbonCommandFactory ribbonCommandFactory2(final SpringClientFactory clientFactory) {
        return new RestClientRibbonCommandFactory(clientFactory);
    }

}
