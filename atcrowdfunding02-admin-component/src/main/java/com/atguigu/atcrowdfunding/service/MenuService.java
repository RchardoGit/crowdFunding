package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.entity.Menu;

import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/12/8 10:11
 */
public interface MenuService {

    List<Menu> getAllMenu();

    void saveMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenu(Integer id);
}
