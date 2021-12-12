package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.commResult.CommonResult;
import com.atguigu.atcrowdfunding.entity.Menu;
import com.atguigu.atcrowdfunding.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther konglingyang
 * @date 2021/12/8 10:20
 */
@RestController
public class MenuController {

    @Resource
    private MenuService menuService;


    @RequestMapping(value = "/menu/get/whole/tree.json")
    public CommonResult<Menu> getAllMenu() {
        // 1.得到所有的menu
        List<Menu> allMenu = menuService.getAllMenu();
        // 2.声明一个变量用来存储找到的根节点
        Menu root = null;
        // 2.遍历集合，并将menu对象和其对应id封装到Map中
        Map<Integer, Menu> menuMap = new HashMap<>();
        for (Menu menu : allMenu) {
            Integer id = menu.getId();
            menuMap.put(id,menu);
        }

        // 3.再次遍历集合取出menu的pid
        for (Menu menu : allMenu) {
            Integer pid = menu.getPid();
            // 4.若pid为空，不在执行，继续执行其他的
            if(pid == null) {
                root = menu;
                // 如果当前节点是根节点，那么肯定没有父节点，故跳过
                continue;
            }

            // 5.若不为空，则根据pid从map中查找父节点
            Menu father = menuMap.get(pid);
            // 6.将当前节点存到父节点
            father.getChildren().add(menu);
        }
        System.out.println(root);

        // 根节点包含了整个树形结构，返回根节点就是返回整个树
        return CommonResult.successWithData(root);
    }

    @RequestMapping(value = "menu/save.json")
    public CommonResult<String> saveMenu(Menu menu) {
        menuService.saveMenu(menu);
        return CommonResult.successWithoutData();
    }

    @RequestMapping(value = "menu/update.json")
    public CommonResult<String> updateMenu(Menu menu) {
        menuService.updateMenu(menu);
        return CommonResult.successWithoutData();
    }


    @RequestMapping(value = "menu/remove.json")
    public CommonResult<String> deleteMenu(@RequestParam("id") Integer id) {
        menuService.deleteMenu(id);
        return CommonResult.successWithoutData();
    }
}
