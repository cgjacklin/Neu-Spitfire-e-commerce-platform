package com.neusoft.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.neusoft.backend.Mapper")
@SpringBootApplication
@EnableCaching
public class BackendApplication {

    private static Logger logger = LoggerFactory.getLogger(BackendApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(BackendApplication.class, args);

//        logger.trace("trace");
//        logger.debug("debug");
//        logger.info("info");
//        logger.warn("warn");
//        logger.error("error");


    }

}
