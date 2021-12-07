package com.atguigu.atCrowdFunding;

import com.atguigu.atcrowdfunding.dao.AdminMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * @auther konglingyang
 * @date 2021/12/4 21:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class Test {


    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    public  Connection getConnection() throws SQLException {
       return dataSource.getConnection();
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = new Test().getConnection();
        System.out.println(connection);
    }
}
