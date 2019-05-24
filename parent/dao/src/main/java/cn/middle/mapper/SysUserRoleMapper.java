package cn.middle.mapper;

import java.util.List;

import cn.middle.pojo.SysUserRole;
import cn.middle.util.CrudDao;

public interface SysUserRoleMapper extends CrudDao<SysUserRole>{
    
    /**
     * 根据用户ID删除用户角色关系
     * @param record 用户角色关系实体
     * @return 0：失败：1：成功
     */
    int deleteByUserId(SysUserRole record);
    
    /**
     * 批量维护用户角色关系 <br/>
     * @param list 用户角色关系集合
     * @return int 0：失败；1：成功
     */
    int insertSysUserRoles(List<SysUserRole> list);
    
}