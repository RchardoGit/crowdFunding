package com.atguigu.atcrowdfunding.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.test.context.ContextConfiguration;

/**
 * @auther konglingyang
 * @date 2021/12/4 21:07
 */

@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class MybatisConfig {
}
