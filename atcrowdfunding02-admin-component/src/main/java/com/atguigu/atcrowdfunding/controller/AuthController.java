package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.commResult.CommonResult;
import com.atguigu.atcrowdfunding.entity.Auth;
import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.service.AuthService;
import com.atguigu.atcrowdfunding.service.RoleService;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @RequestMapping(value = "/assgin/get/all/auth.json")
    public CommonResult<List<Auth>> getAllAuth() {
        List<Auth> authList = authService.getAll();
        System.out.println(authList);
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
//            // ????????????????????????????????????????????????????????????????????????????????????????????????roleIdList????????????
//            // ??????required=false???????????????????????????????????????
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
//        // 1.?????????????????????
//        List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
//
//        // 2.?????????????????????
//        List<Role> unAssignedRoleList = roleService.getUnAssignedRole(adminId);
//
//        // 3.????????????????????????????????????request.setAttribute("attrName",attrValue);
//        modelMap.addAttribute("assignedRoleList", assignedRoleList);
//        modelMap.addAttribute("unAssignedRoleList", unAssignedRoleList);
//
//        return "assign-role";
//    }

}
