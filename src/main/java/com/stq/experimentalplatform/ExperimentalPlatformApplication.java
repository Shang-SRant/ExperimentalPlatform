package com.stq.experimentalplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.stq.experimentalplatform.mapper")
public class ExperimentalPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExperimentalPlatformApplication.class, args);
    }

}
