package com.neusoft.bsp.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;


@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Value("${filePath}")
    String realPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+realPath+"/");
//        registry.addResourceHandler("/image/**").addResourceLocations("file:/image/");
    }

    
}
