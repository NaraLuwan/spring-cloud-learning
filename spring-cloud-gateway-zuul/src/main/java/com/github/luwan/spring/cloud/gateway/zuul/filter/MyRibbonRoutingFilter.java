package com.github.luwan.spring.cloud.gateway.zuul.filter;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;
import org.springframework.cloud.netflix.zuul.filters.route.*;
import org.springframework.cloud.netflix.zuul.filters.route.apache.HttpClientRibbonCommandFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.InvalidMediaTypeException;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 解决无法同时转发 Multipart 和 JSON 请求的问题
 *
 * @author hechao
 * @date 2019/11/18
 */
@Configuration
public class MyRibbonRoutingFilter extends RibbonRoutingFilter {

    @Autowired
    private RestClientRibbonCommandFactory restClientRibbonCommandFactory;

    @Autowired
    private HttpClientRibbonCommandFactory httpClientRibbonCommandFactory;

    public MyRibbonRoutingFilter(ProxyRequestHelper helper, RibbonCommandFactory<?> ribbonCommandFactory) {
        super(helper, ribbonCommandFactory);
    }

    @Override
    protected ClientHttpResponse forward(RibbonCommandContext context) throws Exception {
        RibbonCommandFactory commandFactory;
        if (isMultipartForm()) {
            commandFactory = this.restClientRibbonCommandFactory;
        } else {
            commandFactory = this.httpClientRibbonCommandFactory;
        }
        System.out.println("RibbonCommandFactory is " + commandFactory.getClass().getCanonicalName());

        RibbonCommand command = commandFactory.create(context);
        Map<String, Object> info = this.helper.debug(context.getVerb(), context.getUri(), context.getHeaders(), context.getParams(), context.getRequestEntity());
        try {
            ClientHttpResponse response = command.execute();
            this.helper.appendDebug(info, response.getStatusCode().value(), response.getHeaders());
            return response;
        } catch (HystrixRuntimeException ex) {
            return handleException(info, ex);
        }
    }

    /**
     * 是否是 Multipart 请求类型
     *
     * @return
     */
    private static boolean isMultipartForm() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String contentType = request.getContentType();
        if (contentType == null) {
            return false;
        }

        try {
            MediaType mediaType = MediaType.valueOf(contentType);
            return MediaType.MULTIPART_FORM_DATA.includes(mediaType);
        } catch (InvalidMediaTypeException ex) {
            return false;
        }
    }
}
