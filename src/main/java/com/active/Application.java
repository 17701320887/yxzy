package com.active;


import com.alibaba.dubbo.config.annotation.Reference;
import com.active.config.SystemConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by zb on 18/03/12.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    @Reference
    private SystemConfig systemConfig;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("----------start success-----------");
    }

}