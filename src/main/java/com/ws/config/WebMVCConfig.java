package com.ws.config;

import com.ws.handler.AuthInterceptor;
import com.ws.handler.CustomHttpHeaderArgumentHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.List;


@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Resource
    private AuthInterceptor authInterceptor;
    @Resource
    private CustomHttpHeaderArgumentHandler customHttpHeaderArgumentHandler;


    /**
     * 添加请求拦截器
     *
     * @param registry 注册服务
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }


    /**
     * 添加参数解析处理器
     *
     * @param resolvers 默认
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(customHttpHeaderArgumentHandler);
    }
}
