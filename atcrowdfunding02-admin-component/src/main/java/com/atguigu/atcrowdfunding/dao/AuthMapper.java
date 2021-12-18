package com.atguigu.atcrowdfunding.dao;


import java.util.List;

import com.atguigu.atcrowdfunding.entity.Auth;
import com.atguigu.atcrowdfunding.entity.AuthExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AuthMapper {
    long countByExample(AuthExample example);

    int deleteByExample(AuthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Auth record);

    int insertSelective(Auth record);

    List<Auth> selectByExample(AuthExample example);

    Auth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByExample(@Param("record") Auth record, @Param("example") AuthExample example);

    int updateByPrimaryKeySelective(Auth record);

    int updateByPrimaryKey(Auth record);

    List<Integer> selectAuthIdByRoleId(Integer roleId);

    void deleteOldRelationship(Integer roleId);

    void insertNewRelationship(@Param("roleId") Integer roleId, @Param("authIdList") List<Integer> authIdList);

    List<String> selectAssignedAuthList(Integer adminId);
}