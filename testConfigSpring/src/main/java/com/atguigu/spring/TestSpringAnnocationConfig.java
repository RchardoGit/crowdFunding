package com.atguigu.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther konglingyang
 * @date 2021/12/10 15:46
 */
@Configuration
public class TestSpringAnnocationConfig {

    @Bean
    public Employee employee() {
        return new Employee();
    }
}
