package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.commResult.CommonResult;
import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.service.AdminService;
import com.atguigu.atcrowdfunding.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/12/9 14:43
 */

@Controller
public class AdminAssignRoleController {

    @Resource
    private AdminService adminService;
    @Resource
    private RoleService roleService;

//    pageNum=${requestScope.pageInfo.pageNum }&keyword=${param.keyword }
    @PreAuthorize("hasRole('部长')")
    @GetMapping(value = "assign/to/assign/role/page.html")
    public String toAdminAssignRolePage(@RequestParam("adminId")Integer adminId,
                                        Model model) {
        // 获取映射的角色
        List<Role> assignedRoles = roleService.getRolesAssignByAdmin(adminId);
        // 储存在请求域
        model.addAttribute("assignedRoles",assignedRoles);
        // 获取没有被映射的角色
        List<Role> notAssignedRoles = roleService.getRolesNotAssignByAdmin(adminId);
        // 储存在请求域
        model.addAttribute("notAssignedRoles",notAssignedRoles);
        return "assign-role";
    }

    @PostMapping(value = "assign/do/role/assign.html")
    public String saveAdminAssignRole(@RequestParam("adminId")Integer adminId,
                                      @RequestParam("pageNum")Integer pageNum,
                                      @RequestParam("keyword")String keyword,
                                      @RequestParam("roleIdList")List<Integer> roleIdList) {
        adminService.saveAdminAssignRole(adminId,roleIdList);

        return "redirect:/admin/list/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }
}
