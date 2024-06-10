package com.example.demo.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//            registry.addInterceptor(new ExpLoginInterceptor())
//                    .addPathPatterns("/**")
//                    .excludePathPatterns("/","/JumpInExp","/demo/**","/ExpLogin","/index","/static/**","/views/include/login.html");
//
//    }



}
