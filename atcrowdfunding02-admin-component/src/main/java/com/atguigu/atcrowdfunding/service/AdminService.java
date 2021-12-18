package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/12/5 9:36
 */
public interface AdminService {

    Admin getAdminByLoginAcct(String loginAcct, String userPswd);

    void saveAdmin(Admin admin);

    List<Admin> getAllAdmin();

    PageInfo<Admin> getAdminByKeyword(String keyword, Integer pageNum, Integer pageSize);

    void removeAdminById(Integer adminId);

    Admin getAdminById(Integer id);

    void update(Admin admin);

    void saveAdminAssignRole(Integer adminId, List<Integer> roleIdList);

    Admin getAdminByUserName(String loginAcct);
}
