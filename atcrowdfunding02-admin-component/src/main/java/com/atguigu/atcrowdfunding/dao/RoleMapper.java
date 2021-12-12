package com.atguigu.atcrowdfunding.dao;


import java.util.List;

import com.atguigu.atcrowdfunding.entity.Role;
import com.atguigu.atcrowdfunding.entity.RoleExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> selectByKeyword(String keyword);

    List<Role> getRolesAssignByAdmin(Integer adminId);

    List<Role> getRolesNotAssignByAdmin(Integer adminId);
}