package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.entity.Auth;

import java.util.List;
import java.util.Map;

/**
 * @auther konglingyang
 * @date 2021/12/10 0:01
 */
public interface AuthService {
    List<Auth> getAll();

    List<Integer> getAuthIdByRoleId(Integer roleId);

    void saveRoleAuthRelathinship(Map<String, List<Integer>> map);
}
