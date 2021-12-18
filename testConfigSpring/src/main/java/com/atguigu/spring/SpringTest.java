package com.atguigu.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther konglingyang
 * @date 2021/12/10 15:56
 */
public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(TestSpringAnnocationConfig.class);
        Employee bean = applicationContext.getBean(Employee.class);
        System.out.println(bean);
    }
}
