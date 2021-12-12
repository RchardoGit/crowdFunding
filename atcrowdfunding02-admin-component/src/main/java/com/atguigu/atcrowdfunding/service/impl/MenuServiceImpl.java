package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atCrowdFunding.stant.CrowdConstant;
import com.atguigu.atcrowdfunding.dao.MenuMapper;
import com.atguigu.atcrowdfunding.entity.Menu;
import com.atguigu.atcrowdfunding.entity.MenuExample;
import com.atguigu.atcrowdfunding.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther konglingyang
 * @date 2021/12/8 10:12
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    public List<Menu> getAllMenu() {
        return menuMapper.selectByExample(new MenuExample());
    }

    @Override
    public void saveMenu(Menu menu) {
        if(menu == null) {
            throw new RuntimeException(CrowdConstant.MENU_NULL_EXCEPTION);
        }
        menuMapper.insertSelective(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
       menuMapper.updateByPrimaryKeySelective(menu);
    }

    @Override
    public void deleteMenu(Integer id) {
        menuMapper.deleteByPrimaryKey(id);
    }
}
