package com.github.luwan.spring.cloud.gateway.zuul.config;

import com.github.luwan.spring.cloud.gateway.zuul.base.BaseConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 解决 SpringBoot 将 put 请求最终用 POST 方式提交导致 form-data 参数丢失的问题
 *
 * @author luwan
 * @date 2020/1/10
 */
@Configuration
public class MultipartResolverConfig {

    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver() {
            @Override
            public boolean isMultipart(HttpServletRequest request) {
                String method = request.getMethod().toLowerCase();
                if (!Arrays.asList(BaseConstants.HTTP_METHOD_PUT, BaseConstants.HTTP_METHOD_POST).contains(method)) {
                    return false;
                }
                String contentType = request.getContentType();
                return (contentType != null && contentType.toLowerCase().startsWith("multipart/"));
            }
        };
    }

}
