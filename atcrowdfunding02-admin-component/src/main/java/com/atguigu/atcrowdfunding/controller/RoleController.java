package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atCrowdFunding.stant.CrowdConstant;
import com.atguigu.atcrowdfunding.commResult.CommonResult;
import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/12/7 16:40
 */
@RestController
public class RoleController {

    @Resource
    private RoleService roleService;

    @PreAuthorize("hasRole('部长')")
    @RequestMapping(value = "/role/get/page/info.json")
    public CommonResult<PageInfo<Role>> getRoles(@RequestParam(value = "keyword",defaultValue = "")String keyword,
                                                 @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                                 @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                 Model model) {
        PageInfo<Role> pageInfo = roleService.getPageInfoBykeyword(keyword, pageNum, pageSize);
        model.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO,pageInfo);
        return CommonResult.successWithData(pageInfo);
    }


    @RequestMapping(value = "/role/save.json")
    public CommonResult<String> addRole(Role role) {

        roleService.save(role);

        return CommonResult.successWithoutData();
    }


    @RequestMapping(value = "/role/remove/by/role/id/array.json")
    public CommonResult<String> deleteRoleByIdArray(@RequestBody List<Integer> roleIdList) {
        roleService.deleteRole(roleIdList);

        return CommonResult.successWithoutData();
    }


    @RequestMapping(value = "/role/update.json")
    public CommonResult<String> updateRoleById(Role role) {

        roleService.updateRole(role);

        return CommonResult.successWithoutData();
    }
}
