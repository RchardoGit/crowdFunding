package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atCrowdFunding.stant.CrowdConstant;
import com.atguigu.atCrowdFunding.util.CrowdUtil;
import com.atguigu.atcrowdfunding.entity.Admin;
import com.atguigu.atcrowdfunding.service.AdminService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/12/5 11:42
 */
@Slf4j
@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

//    @GetMapping(value = "/test/ssm.html")
//    public String getSSm(Model model, HttpServletRequest request) {
//
//        List<Admin> allAdmin = adminService.getAllAdmin();
//        model.addAttribute("allAdmin", allAdmin);
//        int i = 10 / 0;
//        boolean b = CrowdUtil.judgeRequstType(request);
//        log.info("=========================" + b);
//        return "target";
//    }
//
//    @ResponseBody
//    @PostMapping(value = "/send/array.json")
//    public String sendArray(@RequestParam("array[]") List<Integer> array) {
//
//        return "success";
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/send/two.html")
//    public String sendStudent(@RequestBody List<Integer> array, HttpServletRequest request) {
//        boolean b = CrowdUtil.judgeRequstType(request);
//        log.info("" + b);
//        return "success";
//    }

    /**
     * 管理员登录
     * @param loginAcct 请求参数
     * @param userPswd 请求参数
     * @param session
     * @return
     */
//    @PostMapping(value = "/admin/do/login.html")
//    public String login(@RequestParam("loginAcct") String loginAcct,
//                        @RequestParam("userPswd") String userPswd,
//                        HttpSession session) {
//        Admin admin = adminService.getAdminByLoginAcct(loginAcct,userPswd);
//        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);
//
//        return "redirect:/admin/do/main/page.html";
//    }

    /**
     * 管理员退出系统
     * @return
     */
//    @GetMapping(value = "/admin/main/logout.html")
//    public String logout() {
//        return "redirect:/admin/do/login/page.html";
//    }

    @RequestMapping(value ="/admin/list/page.html" )
    public String getAdminByKeyword(@RequestParam(value = "keyword",defaultValue = "")String keyword,
                                    @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum,
                                    @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                    Model model){
        PageInfo<Admin> pageInfo = adminService
                .getAdminByKeyword(keyword, pageNum, pageSize);
        model.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO,pageInfo);
        System.out.println("已经插入====================================" +
                "==================================");
        return "admin-page";

    }

    /**
     * 删除单个人员
     * @param adminId
     * @param pageNum
     * @param keyword
     * @return
     */
    @RequestMapping(value ="/admin/remove/{adminId}/{pageNum}/{keyword}.html")
    public String removeAdminById(@PathVariable("adminId")Integer adminId,
                                  @PathVariable("pageNum")Integer pageNum,
                                  @PathVariable("keyword")String keyword) {

        adminService.removeAdminById(adminId);
        // return "admin-page"  方案一：会无法显示分页数据
        //return "forward:/admin/list/page.html"  方案二：会重复删除
        return "redirect:/admin/list/page.html?pageNum=" + pageNum + "&keyword=" + keyword;
    }

    @PostMapping(value = "/admin/save.html")
    public String saveAdmin(Admin admin) {

        adminService.saveAdmin(admin);
        return "redirect:/admin/list/page.html?pageNum=" + Integer.MAX_VALUE;

    }

    @GetMapping(value = "admin/to/edit/page.html")
    public String toEditPage(@RequestParam("adminId")Integer id,
                             @RequestParam("pageNum")Integer pageNum,
                             Model model) {
        Admin admin = adminService.getAdminById(id);
        model.addAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);
        return "admin-edit";
    }

    @PostMapping(value = "/admin/update.html")
    public String updateAdmin(Admin admin,
                              @RequestParam("pageNum")Integer pageNum) {
        adminService.update(admin);
        return "redirect:/admin/list/page.html?pageNum=" + pageNum;
    }

}
