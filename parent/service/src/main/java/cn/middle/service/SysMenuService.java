package cn.middle.service;

import java.util.List;

import cn.middle.pojo.SysMenu;
import cn.middle.pojo.SysUser;

public interface SysMenuService {

    int deleteByPrimaryKey(String menuId);

    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(String menuId);

    int updateByPrimaryKeySelective(SysMenu record);

    /**
     * 根据条件查询菜单列表
     * @param record 菜单实体
     * @return List<SysMenu> 返回菜单list集合
     */
    List<SysMenu> findList(SysMenu record);
    
    /**
     * 保存菜单信息
     * @param record 菜单实体
     * @param currentUser 当前登录用户
     * @return int 0：失败；1：成功
     */
    int save(SysMenu record, SysUser currentUser);
    
    /**
     * 根据菜单ID删除菜单信息
     * @param record 菜单实体
     * @param currentUser 当前登录用户
     * @return 0：失败；1：成功
     */
    int deleteByMenuId(SysMenu record, SysUser currentUser);
    
    /**
     * 根据用户ID查询该用户下的菜单
     * @param record 菜单实体
     * @return List<SysMenu> 返回菜单list集合
     */
    List<SysMenu> selectMenuByUserId(SysMenu record);
    
    /**
     * 根据角色查询菜单列表
     * @param record 菜单实体
     * @return List<SysMenu> 返回菜单list集合
     */
    List<SysMenu> findListByRoleId(SysMenu record);
    
}
