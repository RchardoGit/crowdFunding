package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.dao.AuthMapper;
import com.atguigu.atcrowdfunding.entity.Auth;
import com.atguigu.atcrowdfunding.entity.AuthExample;
import com.atguigu.atcrowdfunding.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @auther konglingyang
 * @date 2021/12/10 0:01
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthMapper authMapper;

    @Override
    public List<Auth> getAll() {
        List<Auth> auths = authMapper.selectByExample(new AuthExample());
        return auths;
    }

    @Override
    public List<Integer> getAuthIdByRoleId(Integer roleId) {
        authMapper.selectAuthIdByRoleId(roleId);
        return null;
    }

    @Override
    public void saveRoleAuthRelathinship(Map<String, List<Integer>> map) {
        // 获取roleId的值
        List<Integer> roleIdList = map.get("roleId");
        Integer roleId = roleIdList.get(0);
        // 删除旧关联数据
        authMapper.deleteOldRelationship(roleId);
        // 获取authIdList
        List<Integer> authIdList = map.get("authIdArray");
        // 判断authIdList是否有效
        if(authIdList != null && authIdList.size() >0) {
            authMapper.insertNewRelationship(roleId,authIdList);
        }
    }
}
