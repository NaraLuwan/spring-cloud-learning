package com.github.luwan.spring.cloud.gateway.zuul.config;

import com.github.luwan.spring.cloud.gateway.zuul.filter.MyRibbonRoutingFilter;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandFactory;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonRoutingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hechao
 * @date 2019/11/18
 */
@Configuration
public class RibbonFilterConfig {

    @Bean
    public RibbonRoutingFilter ribbonRoutingFilter(ProxyRequestHelper helper,
                                                   RibbonCommandFactory<?> ribbonCommandFactory) {

        RibbonRoutingFilter filter = new MyRibbonRoutingFilter(helper,
                ribbonCommandFactory);
        return filter;
    }
}
