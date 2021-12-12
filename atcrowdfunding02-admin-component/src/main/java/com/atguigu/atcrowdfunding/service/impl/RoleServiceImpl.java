package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atCrowdFunding.exception.RoleAlreadyException;
import com.atguigu.atCrowdFunding.stant.CrowdConstant;
import com.atguigu.atcrowdfunding.dao.RoleMapper;
import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.entity.RoleExample;
import com.atguigu.atcrowdfunding.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/12/7 16:39
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    // 分页角色展示
    @Override
    public PageInfo<Role> getPageInfoBykeyword(String keyword,Integer pageNum,Integer pageSize) {

        // 开启pageHelp插件
        Page page = PageHelper.startPage(pageNum, pageSize);

        // 查询role
        List<Role> roles = roleMapper.selectByKeyword(keyword);
        // 封装pageInfo
        return new PageInfo<>(roles);
    }

    @Override
    public void save(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void deleteRole(List<Integer> idList) {

        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andIdIn(idList);
        roleMapper.deleteByExample(roleExample);


    }



    @Override
    public void updateRole(Role role) {

        try {
            roleMapper.updateByPrimaryKeySelective(role);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleAlreadyException(CrowdConstant.ROLE_ALIVED_EXCEPTION);
        }
    }

    @Override
    public List<Role> getRolesAssignByAdmin(Integer adminId) {
        List<Role> assignedRoles = roleMapper.getRolesAssignByAdmin(adminId);
        return assignedRoles;
    }

    @Override
    public List<Role> getRolesNotAssignByAdmin(Integer adminId) {
        List<Role> notAssignedRoles = roleMapper.getRolesNotAssignByAdmin(adminId);
        return notAssignedRoles;
    }
}
