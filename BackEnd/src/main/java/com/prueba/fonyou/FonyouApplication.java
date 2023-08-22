package com.prueba.fonyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.prueba.fonyou")
public class FonyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(FonyouApplication.class, args);
    }

}
