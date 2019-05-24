package cn.middle.mapper;

import java.util.List;

import cn.middle.pojo.SysRole;
import cn.middle.pojo.SysUserData;
import cn.middle.util.CrudDao;

public interface SysUserDataMapper extends CrudDao<SysRole>{
    
    /**
     * 根据条件逻辑删除用户数据权限关系
     * @param record 用户数据权限实体
     * @return 0:失败；1：成功
     */
    int deleteByLoc(SysUserData record);
    
    /**
     * 批量插入用户数据权限关系
     * @param list 用户数据权限list集合
     * @return 0:失败；1：成功
     */
    int insertList(List<SysUserData> list);
    
    /**
     * 根据条件查询用户数据权限关系集合
     * @param record 用户数据权限实体
     * @return List<SysUserData> 返回用户数据权限list集合
     */
    List<SysUserData> findList(SysUserData record);
    
}