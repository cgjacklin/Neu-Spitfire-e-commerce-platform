package com.neusoft.bsp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@MapperScan("com.neusoft.bsp.*.*.mapper")
@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class BspApplication {

    @PostConstruct
    void started()
    {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }
    public static void main(String[] args) {
        SpringApplication.run(BspApplication.class, args);
    }

}
