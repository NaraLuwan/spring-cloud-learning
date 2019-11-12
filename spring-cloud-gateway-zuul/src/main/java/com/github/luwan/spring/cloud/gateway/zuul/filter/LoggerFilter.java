package com.github.luwan.spring.cloud.gateway.zuul.filter;

import com.github.luwan.spring.cloud.gateway.zuul.base.BaseConstants;
import com.github.luwan.spring.cloud.gateway.zuul.base.RequestContextConstants;
import com.github.luwan.spring.cloud.gateway.zuul.base.ZuulFilterConstants;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author luwan
 * @date 2019/11/12
 */
@Configuration
public class LoggerFilter extends ZuulFilter {

    private static final Logger log = LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    public String filterType() {
        return ZuulFilterConstants.POST_TYPE;
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
        try {
            RequestContext context = RequestContext.getCurrentContext();

            HttpServletRequest request = context.getRequest();
            String requestUrl = request.getRequestURI();

            InputStream requestInputStream = request.getInputStream();
            String requestBody = StreamUtils.copyToString(requestInputStream, BaseConstants.DEFAULT_CHARSET);

            InputStream responseDataStream = context.getResponseDataStream();
            String responseBody = StreamUtils.copyToString(responseDataStream, BaseConstants.DEFAULT_CHARSET);
            // 取出response 信息后需要再手动放回去
            context.setResponseBody(responseBody);

            String requestId = (String) context.get(RequestContextConstants.REQUEST_TRACE_ID);
            long startTime = (long) context.get(RequestContextConstants.REQUEST_START_TIME);
            long duration = System.currentTimeMillis() - startTime;

            log.info("请求ID=>{}, 接口=>{}, 参数=>{}, 耗时=>{}ms, 返回=>{}", requestId, requestUrl, requestBody, duration, responseBody);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
