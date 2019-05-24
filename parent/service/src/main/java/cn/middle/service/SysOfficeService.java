package cn.middle.service;

import java.util.List;

import cn.middle.pojo.SysOffice;
import cn.middle.pojo.SysUser;

public interface SysOfficeService {

    int deleteByPrimaryKey(String officeId);

    int insertSelective(SysOffice record);

    SysOffice selectByPrimaryKey(String officeId);

    int updateByPrimaryKeySelective(SysOffice record);

    /**
     * 根据条件查询部门信息 
     * @param record 部门实体
     * @return List<SysOffice> 返回部门list集合
     */
    List<SysOffice> findList(SysOffice record);
    
    /**
     * 保存部门信息
     * @param record 部门实体
     * @param currentUser 当前登录用户
     * @return int 0：失败；1：成功
     */
    int save(SysOffice record, SysUser currentUser);
    
    /**
     * 根据部门ID删除部门信息
     * @param record 部门实体
     * @param currentUser 当前登录用户
     * @return 0：失败；1：成功
     */
    int deleteByOfficeId(SysOffice record, SysUser currentUser);
}
