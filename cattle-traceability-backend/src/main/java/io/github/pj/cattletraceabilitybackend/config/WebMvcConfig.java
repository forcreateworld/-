package io.github.pj.cattletraceabilitybackend.config;

import com.example.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 排除登录和注册接口的拦截
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/customer/register",
                        "/customer/login",
                        "/factoryUser/register",
                        "/factoryUser/login"
                );
    }}
/*

这个配置类实现了 WebMvcConfigurer 接口，用于配置 Spring MVC 相关的设置。
通过 @Autowired 注入了一个 LoginInterceptor 实例，这是一个自定义的拦截器类，用于检查用户的登录状态。
addInterceptors 方法中，我们注册了 loginInterceptor 这个拦截器，并配置了它的拦截路径和排除路径。
addPathPatterns("/**") 表示拦截所有请求路径。
excludePathPatterns(...) 排除了 /customer/register、/customer/login、/factoryUser/register 和 /factoryUser/login 这些路径，即不需要登录就可以访问这些路径。
这个配置的作用是，对于所有的请求路径（除了登录和注册接口），都需要经过 LoginInterceptor 的检查，确保用户已经登录才能访问。这样可以保护系统的安全性，防止未经授权的访问。
你可以查看 LoginInterceptor 的具体实现逻辑，了解它是如何检查用户登录状态的。*/
