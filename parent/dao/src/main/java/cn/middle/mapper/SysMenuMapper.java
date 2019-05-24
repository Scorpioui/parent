package cn.middle.mapper;

import java.util.List;

import cn.middle.pojo.SysMenu;
import cn.middle.util.CrudDao;

public interface SysMenuMapper extends CrudDao<SysMenu> {

    /**
     * 根据条件查询菜单列表
     * @param record 菜单实体
     * @return List<SysMenu> 返回菜单list集合
     */
    List<SysMenu> findList(SysMenu record);
    
    /**
     * 根据用户ID查询该用户下的菜单
     * @param record 菜单实体
     * @return List<SysMenu> 返回菜单list集合
     */
    List<SysMenu> selectMenuByUserId(SysMenu record);
    
    /**
     * 查询菜单下子菜单数量
     * @param record 菜单实体
     * @return int 查询菜单下子菜单数量
     */
    int getMenuCount(SysMenu record);
    
    /**
     * 根据菜单ID删除菜单信息
     * @param record 菜单实体
     * @return int 0：失败；1：成功
     */
    int deleteByMenuId(SysMenu record);
    
    /**
     * 根据角色查询菜单列表
     * @param record 菜单实体
     * @return List<SysMenu> 返回菜单list集合
     */
    List<SysMenu> findListByRoleId(SysMenu record);
    
}