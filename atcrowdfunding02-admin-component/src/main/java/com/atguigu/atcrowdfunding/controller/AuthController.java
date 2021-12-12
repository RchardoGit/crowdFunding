package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.commResult.CommonResult;
import com.atguigu.atcrowdfunding.entity.Auth;
import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.service.AuthService;
import com.atguigu.atcrowdfunding.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @auther konglingyang
 * @date 2021/12/10 0:02
 */
@Controller
public class AuthController {

    @Resource
    private AuthService authService;
    @Resource
    private RoleService roleService;

    @ResponseBody
    @RequestMapping(value = "/assign/get/all/auth.json")
    public CommonResult<List<Auth>> getAllAuth() {
        List<Auth> authList = authService.getAll();
        return CommonResult.successWithData(authList);
    }

    @ResponseBody
    @RequestMapping(value = "/assign/get/assigned/auth/id/by/role/id.json")
    public CommonResult<List<Integer>> getAuthByRoleId(@RequestParam("roleId")Integer roleId) {

        List<Integer> authIdList = authService.getAuthIdByRoleId(roleId);

        return CommonResult.successWithData(authIdList);
    }


    @ResponseBody
    @RequestMapping("/assign/do/role/assign/auth.json")
    public CommonResult<String> saveRoleAuthRelathinship(
            @RequestBody Map<String, List<Integer>> map) {

        authService.saveRoleAuthRelathinship(map);

        return CommonResult.successWithoutData();
    }
//
//    @ResponseBody
//    @RequestMapping("/assign/get/assigned/auth/id/by/role/id.json")
//    public ResultEntity<List<Integer>> getAssignedAuthIdByRoleId(
//            @RequestParam("roleId") Integer roleId) {
//
//        List<Integer> authIdList = authService.getAssignedAuthIdByRoleId(roleId);
//
//        return ResultEntity.successWithData(authIdList);
//    }
//
//
//
//    @RequestMapping("/assign/do/role/assign.html")
//    public String saveAdminRoleRelationship(
//            @RequestParam("adminId") Integer adminId,
//            @RequestParam("pageNum") Integer pageNum,
//            @RequestParam("keyword") String keyword,
//
//            // 我们允许用户在页面上取消所有已分配角色再提交表单，所以可以不提供roleIdList请求参数
//            // 设置required=false表示这个请求参数不是必须的
//            @RequestParam(value="roleIdList", required=false) List<Integer> roleIdList
//    ) {
//
//        adminService.saveAdminRoleRelationship(adminId, roleIdList);
//
//        return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
//    }
//
//    @RequestMapping("/assign/to/assign/role/page.html")
//    public String toAssignRolePage(
//
//            @RequestParam("adminId") Integer adminId,
//
//            ModelMap modelMap
//
//    ) {
//
//        // 1.查询已分配角色
//        List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
//
//        // 2.查询未分配角色
//        List<Role> unAssignedRoleList = roleService.getUnAssignedRole(adminId);
//
//        // 3.存入模型（本质上其实是：request.setAttribute("attrName",attrValue);
//        modelMap.addAttribute("assignedRoleList", assignedRoleList);
//        modelMap.addAttribute("unAssignedRoleList", unAssignedRoleList);
//
//        return "assign-role";
//    }

}
