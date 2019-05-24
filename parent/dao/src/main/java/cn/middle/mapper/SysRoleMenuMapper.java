package cn.middle.mapper;

import java.util.List;

import cn.middle.pojo.SysRoleMenu;
import cn.middle.util.CrudDao;

public interface SysRoleMenuMapper extends CrudDao<SysRoleMenu>{

    /**
     * 根据用户ID删除角色菜单关系
     * @param record 角色菜单关系实体
     * @return 0：失败：1：成功
     */
    int deleteByRoleId(SysRoleMenu record);
    
    /**
     * 批量维护用户角色关系 <br/>
     * @param list 用户角色关系集合
     * @return int 0：失败；1：成功
     */
    int insertSysRoleMenus(List<SysRoleMenu> list);
}