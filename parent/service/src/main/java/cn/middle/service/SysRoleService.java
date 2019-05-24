package cn.middle.service;

import java.util.List;

import cn.middle.pojo.SysRole;
import cn.middle.pojo.SysUser;

public interface SysRoleService {

    int deleteByPrimaryKey(String roleId);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(SysRole record);
    
    /**
     * 根据条件查询角色列表
     * @param record 角色实体
     * @return List<SysRole> 返回角色list集合
     */
    List<SysRole> findList(SysRole record);
    
    /**
     * 根据角色ID查询所拥有的角色信息
     * @param record 角色实体
     * @return List<SysRole> 返回角色list集合
     */
    List<SysRole> selectRoleByUserId(SysRole record);
    
    /**
     * 查询角色分页数据
     * @param record 角色实体
     * @param pageSize  每页的条数
     * @param pageIndex  当前页数
     * @return List<SysUser> 返回订单list集合
     */
    List<SysRole> findPage(SysRole record, int pageSize, int pageIndex);
    
    /**
     * 查询角色总数量
     * @param record 角色实体
     * @return int 角色总数量
     */
    int getCount(SysRole record);
    
    /**
     * 保存角色信息
     * @param record 角色实体
     * @param currentUser 当前登录用户
     * @return int 0：失败；1：成功
     */
    int save(SysRole record, SysUser currentUser);
    
    /**
     * 保存角色授权信息
     * @param record 角色实体
     * @return int 0：失败；1：成功
     */
    int saveRoleAuthoriza(SysRole record);
    
    /**
     * 根据角色ID删除角色信息
     * @param record 角色实体
     * @param currentUser 当前登录用户
     * @return 0：失败；1：成功
     */
    int deleteByRoleId(SysRole record, SysUser currentUser);
}
