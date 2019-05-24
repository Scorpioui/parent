package cn.middle.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.middle.mapper.SysRoleMapper;
import cn.middle.mapper.SysUserDataMapper;
import cn.middle.mapper.SysUserMapper;
import cn.middle.mapper.SysUserRoleMapper;
import cn.middle.pojo.SysUser;
import cn.middle.pojo.SysUserData;
import cn.middle.pojo.SysUserRole;
import cn.middle.service.SysUserService;
import cn.middle.util.MD5Util;
import cn.middle.util.StringUtils;
import cn.middle.util.UuidGeneration;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService{

    /**
     * 用户Dao
     */
    @Resource
    private SysUserMapper sysUserMapper;
    
    /**
     * 角色Dao
     */
    @Resource
    private SysRoleMapper sysRoleMapper;
    
    /**
     * 用户角色Dao
     */
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    
    /**
     * 用户数据权限关系Dao
     */
    @Resource
    private SysUserDataMapper sysUserDataMapper;
    
    @Override
    public int deleteByPrimaryKey(String userId) {
        return sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(String userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public SysUser selectByUserId(SysUser record) {
        return sysUserMapper.selectByUserId(record);
    }
    
    @Override
    public List<SysUser> findList(SysUser record) {
        return sysUserMapper.findList(record);
    }

    @Override
    public List<SysUser> findPage(SysUser record, int pageSize, int pageIndex) {
        return sysUserMapper.findPage(record, pageSize, pageIndex);
    }

    @Override
    public int getCount(SysUser record) {
        return sysUserMapper.getCount(record);
    }
    
    @Override
    @Transactional(rollbackFor=Exception.class) // 加入事务，如果出现异常，则回滚事务
    public int save(SysUser record, SysUser currentUser) {
        
        if (StringUtils.isNotBlank(record.getUserId())){
            record.setUpdateUser(currentUser.getUserId());
            record.setUpdateTime(new Date());
            record.setDelFlag("0");
            
            // 删除数据权限关系表数据
            SysUserData temp = new SysUserData();
            temp.setUserId(record.getUserId()); // 用户Id
            temp.setDelFlag("1");
            sysUserDataMapper.deleteByLoc(temp); // 逻辑删除用户数据权限关系集合
            // 插入数据权限关系表数据
            SysUserData sysUserData = new SysUserData();
            sysUserData.setSysUserDataId(UuidGeneration.getUUID()); // 主键
            sysUserData.setUserId(record.getUserId()); // 用户Id
            sysUserData.setDataPermissionsId(record.getSysOffice().getOfficeId()); // 用户所属2级机构Id
            sysUserData.setDelFlag("0");
            List<SysUserData> list = new ArrayList<SysUserData>(); // 实例化用户数据权限关系集合
            list.add(sysUserData);
            sysUserDataMapper.insertList(list); // 批量插入用户数据权限关系表
            
            return sysUserMapper.updateByPrimaryKeySelective(record); // 更新用户表
        } else {
            record.setUserId(UuidGeneration.getUUID());
            // 密码加密
            String password = MD5Util.getMd5(record.getPassword());
            record.setPassword(password);
            record.setCreateUser(currentUser.getUserId());
            record.setCreateTime(new Date());
            record.setDelFlag("0");
            // 删除数据权限关系表数据
            SysUserData temp = new SysUserData();
            temp.setUserId(record.getUserId()); // 用户Id
            temp.setDelFlag("1");
            sysUserDataMapper.deleteByLoc(temp); // 逻辑删除用户数据权限关系集合
            // 插入数据权限关系表数据
            SysUserData sysUserData = new SysUserData();
            sysUserData.setSysUserDataId(UuidGeneration.getUUID()); // 主键
            sysUserData.setUserId(record.getUserId()); // 用户Id
            sysUserData.setDataPermissionsId(record.getSysOffice().getOfficeId()); // 用户所属2级机构Id
            sysUserData.setDelFlag("0");
            List<SysUserData> list = new ArrayList<SysUserData>(); // 实例化用户数据权限关系集合
            list.add(sysUserData);
            sysUserDataMapper.insertList(list); // 批量插入用户数据权限关系表
            
            return sysUserMapper.insertSelective(record); // 插入用户表
        }
    }

    @Override
    public int deleteByUserId(SysUser record, SysUser currentUser) {
        
        record.setUpdateUser(currentUser.getUserId());
        record.setUpdateTime(new Date());
        record.setDelFlag("1");
        return sysUserMapper.deleteByUserId(record);
    }

    @Override
    @Transactional(rollbackFor=Exception.class) // 加入事务，如果出现异常，则回滚事务
    public int saveUserAuthoriza(SysUser record) {
        
        if(StringUtils.isNotBlank(record.getUserId())) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(record.getUserId());
            // 删除所有的用户关系
            sysUserRoleMapper.deleteByUserId(sysUserRole);
            
            // 重新维护用户角色关系
            List<SysUserRole> voList = new ArrayList<SysUserRole>();
            String strs[] = null;
            if(StringUtils.isNotBlank(record.getRoleIds())) {
                strs = record.getRoleIds().split(",");
            }
            if(strs != null && strs.length > 0) {
                for(int i = 0 ; i < strs.length ; i ++) {
                    SysUserRole temp = new SysUserRole();
                    temp.setSysUserRoleId(UuidGeneration.getUUID());
                    temp.setUserId(record.getUserId());
                    temp.setRoleId(strs[i]);
                    voList.add(temp);
                }
            }
            if(voList != null && voList.size() > 0) {
                sysUserRoleMapper.insertSysUserRoles(voList);
            }
            return 1;
        }
        return 0;
    }

    @Override
    public int initializaPassword(SysUser record, SysUser currentUser) {
        
        record.setUpdateUser(currentUser.getUserId());
        record.setUpdateTime(new Date());
        record.setDelFlag("0");
        return sysUserMapper.initializaPassword(record);
    }

}
