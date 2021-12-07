package com.atguigu.atCrowdFunding.test;

import com.atguigu.atCrowdFunding.util.CrowdUtil;
import org.junit.Test;

/**
 * @auther konglingyang
 * @date 2021/12/6 11:53
 */
public class CrowdTest {

    String password = "123456";
    @Test
    public void testMD5() {
        String s = CrowdUtil.md5(password);
        System.out.println(s);
    }
}
