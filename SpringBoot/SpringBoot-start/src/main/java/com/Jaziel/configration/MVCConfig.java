package com.Jaziel.configration;

import com.Jaziel.interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 王杰
 * @time 2020/11/4 16:06
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {

    /**将拦截器注册到 spring ioc 容器中*/
    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    /**重写该方法，将自定义拦截器添加到拦截器链中*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 通过 registry 添加 myInterceptor 拦截器，并且设置拦截路径为 /*
        registry.addInterceptor(myInterceptor()).addPathPatterns("/*");
    }
}
