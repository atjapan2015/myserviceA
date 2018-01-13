package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservice.myserviceA.register.ConsulRegisterListener;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MyserviceAApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MyserviceAApplication.class);
        application.addListeners(new ConsulRegisterListener());
        application.run(args);
    }
}
