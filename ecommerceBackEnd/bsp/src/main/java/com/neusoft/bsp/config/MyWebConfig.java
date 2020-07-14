package com.neusoft.bsp.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;


@Configuration
public class MyWebConfig implements WebMvcConfigurer {
//
//    String realPath = new String("commerceBackEnd/bsp/src/main/resources/static/upload");
//    File file = new File(realPath);
//    File newFile = new File(file.getAbsolutePath() + File.separator);

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:///E:/Develop/Files/Photos/");
//        registry.addResourceHandler("/image/**").addResourceLocations("file:///"+newFile);
    }
}
