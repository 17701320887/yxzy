package com.active.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zb on 2017/7/7.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.active")
@MapperScan("com.active.dao")
public class WebMvcConfig extends WebMvcAutoConfiguration {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate restTemplate() {
        restTemplateBuilder.setConnectTimeout(10000);
        restTemplateBuilder.setReadTimeout(5000);
        return restTemplateBuilder.build();
    }

}
