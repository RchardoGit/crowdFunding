package com.atguigu.atcrowdfunding.test;

import com.atguigu.atCrowdFunding.util.CrowdUtil;
import com.atguigu.atcrowdfunding.dao.AdminMapper;
import com.atguigu.atcrowdfunding.entity.Admin;
import com.atguigu.atcrowdfunding.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @auther konglingyang
 * @date 2021/12/4 22:08
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml"})
public class SpringTest1 {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        log.info("dadadadadada");
    }

    @Test
    public void testMapper() {
        String userPswd = CrowdUtil.md5("123456");
        for (int i = 1; i <= 50; i++) {
            Admin admin = new Admin(null, "tom"+i, userPswd, "汤姆"+i, "tom" + i +".@qq.com", null);
            adminService.saveAdmin(admin);
            log.info("tom"+i);
        }


    }

    @Test
    @Transactional
    public void saveAdmin() {
        Admin admin = new Admin(null, "jack", "123123", "杰克", "jack.@qq.com", null);
        adminService.saveAdmin(admin);
    }


}
