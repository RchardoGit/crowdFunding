package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atCrowdFunding.exception.LoginFailedException;
import com.atguigu.atCrowdFunding.exception.UpdateAdminAlreadyException;
import com.atguigu.atCrowdFunding.stant.CrowdConstant;
import com.atguigu.atCrowdFunding.util.CrowdUtil;
import com.atguigu.atcrowdfunding.dao.AdminMapper;
import com.atguigu.atcrowdfunding.entity.Admin;
import com.atguigu.atcrowdfunding.entity.AdminExample;
import com.atguigu.atCrowdFunding.exception.LoginAdminAlreadyException;
import com.atguigu.atcrowdfunding.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @auther konglingyang
 * @date 2021/12/5 9:37
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin getAdminByLoginAcct(String loginAcct, String userPswd) {

        // 1.从数据库中查询人员信息
        // (1)创建AdminEample对象
        AdminExample adminExample = new AdminExample();
        // (2)创建Criteria对象
        AdminExample.Criteria criteria = adminExample.createCriteria();
        // (3) Criteria中封装查询条件
        criteria.andLoginAcctEqualTo(loginAcct);
        // (4)查询并返回结果
        List<Admin> admins = adminMapper.selectByExample(adminExample);
        // 2.查出为空， 抛出异常
        if (admins == null || admins.size() == 0) {
            throw new LoginFailedException(CrowdConstant.LOGIN_USER_NOTALIVE);
        }
        if(admins.size()>1) {
            throw new RuntimeException(CrowdConstant.MESSAGE_SYSTEM_ERROR_USER_NOT_UNIQUE);
        }
        // 3.不为空，进行密码校验,将明文密码转换，密码为空会抛出异常
        String mdPswd = CrowdUtil.md5(userPswd);
        // 4.密码对比返回对象的密码是否一致 不一致， 抛出异常
        Admin admin = admins.get(0);
        String selectUserPswd = admin.getUserPswd();
        if(!Objects.equals(mdPswd,selectUserPswd)) {
            throw new LoginFailedException(CrowdConstant.LOGIN_EXCEPTION);
        }
        // 6.一致则返回该对象
        return admin;
    }

    @Override
    public void saveAdmin(Admin admin) {
        // 转换密码
        String userPswd = CrowdUtil.md5(admin.getUserPswd());
        admin.setUserPswd(userPswd);
        // 创建时间
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = format.format(date);
        admin.setCreateTime(createTime);

        try {
             adminMapper.insertSelective(admin);
        } catch (Exception e) {
            e.printStackTrace();

            if(e instanceof DuplicateKeyException) {
                throw new LoginAdminAlreadyException(CrowdConstant.USER_ALIVED_EXCEPTION);
            }
        }
    }

    @Override
    public List<Admin> getAllAdmin() {
       return adminMapper.selectByExample(new AdminExample());
    }

    @Override
    public PageInfo<Admin> getAdminByKeyword(String keyword, Integer pageNum, Integer pageSize) {
        // 1.开启分页插件
        PageHelper.startPage(pageNum, pageSize);
        // 2.查询数据库
        List<Admin> list = adminMapper.selectAdminByKeyword(keyword);
        // 3.分装到pageInfo对象中

        return  new PageInfo<Admin>(list);
    }

    @Override
    public void removeAdminById(Integer adminId) {
        adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Admin admin) {

        try {
            adminMapper.updateByPrimaryKeySelective(admin);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof DuplicateKeyException) {
                throw new UpdateAdminAlreadyException(CrowdConstant.USER_ALIVED_EXCEPTION);
            }
        }
    }

    @Override
    public void saveAdminAssignRole(Integer adminId, List<Integer> roleIdList) {

        // 先删除表中的数据
        adminMapper.deleteAdminAssignRole(adminId);
        // 添加数据
        if(roleIdList !=null && roleIdList.size()>0) {
            adminMapper.addAdminAssignRole(adminId,roleIdList);
        }
    }
}
