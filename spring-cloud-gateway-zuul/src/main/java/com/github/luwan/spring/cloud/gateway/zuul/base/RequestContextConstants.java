package com.github.luwan.spring.cloud.gateway.zuul.base;

/**
 * zuul全局上下文中自定义的key
 * @author luwan
 * @date 2019/11/12
 */
public class RequestContextConstants {

    /**
     * 请求开始处理时间
     */
    public static final String REQUEST_START_TIME = "requestStartTime";

    /**
     * 请求唯一标识
     */
    public static final String REQUEST_TRACE_ID = "requestTraceId";

}
