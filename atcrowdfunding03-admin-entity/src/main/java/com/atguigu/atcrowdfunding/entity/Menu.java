package com.atguigu.atcrowdfunding.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Menu {
    // 主键
    private Integer id;
    // 父节点id
    private Integer pid;
    // 名字
    private String name;
    // 节点附带的 URL 地址，是将来点击菜单项时要跳转的地址
    private String url;
    // 节点图标
    private String icon;
    // 储存子节点的集合
    private List<Menu> children = new ArrayList<>();
    // 控制节点是否默认为打开装，设置为 true 表示默认打开
    private Boolean open = true;

}