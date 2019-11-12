package com.github.luwan.spring.cloud.gateway.zuul.filter;

import com.github.luwan.spring.cloud.gateway.zuul.base.RequestContextConstants;
import com.github.luwan.spring.cloud.gateway.zuul.base.ZuulFilterConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * @author luwan
 * @date 2019/11/11
 */
@Configuration
public class AccessFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return ZuulFilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        currentContext.set(RequestContextConstants.REQUEST_START_TIME, System.currentTimeMillis());
        currentContext.set(RequestContextConstants.REQUEST_TRACE_ID, UUID.randomUUID().toString());

        return null;
    }
}
