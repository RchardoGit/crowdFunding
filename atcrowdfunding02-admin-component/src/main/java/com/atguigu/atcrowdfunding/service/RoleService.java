package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/12/7 16:39
 */
public interface RoleService {

    PageInfo<Role> getPageInfoBykeyword(String keyword, Integer pageNum, Integer pageSize);

    void save(Role role);

    void deleteRole(List<Integer> idList);

    void updateRole(Role role);

    List<Role> getRolesAssignByAdmin(Integer adminId);

    List<Role> getRolesNotAssignByAdmin(Integer adminId);
}
