package cn.middle.service;

import java.util.List;

import cn.middle.pojo.SysUser;

public interface SysUserService {
    
    int deleteByPrimaryKey(String userId);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 根据主键查询用户信息
     * @param record 用户实体
     * @return SysUser 用户实体
     */
    SysUser selectByUserId(SysUser record);
    
    /**
     * 根据条件查询用户列表
     * @param record 用户实体
     * @return List<SysUser> 返回用户list集合
     */
    List<SysUser> findList(SysUser record);
    
    /**
     * 查询用户分页数据
     * @param record 用户实体
     * @param pageSize  每页的条数
     * @param pageIndex  当前页数
     * @return List<SysUser> 返回订单list集合
     */
    List<SysUser> findPage(SysUser record, int pageSize, int pageIndex);
    
    /**
     * 查询用户总数量
     * @param record 用户实体
     * @return int 用户总数量
     */
    int getCount(SysUser record);
    
    /**
     * 保存用户信息
     * @param record 用户实体
     * @param currentUser 当前登录用户
     * @return int 0：失败；1：成功
     */
    int save(SysUser record, SysUser currentUser);
    
    /**
     * 根据用户ID删除用户信息
     * @param sysUser 用户实体
     * @param currentUser 当前登录用户
     * @return 0：失败；1：成功
     */
    int deleteByUserId(SysUser record, SysUser currentUser);
    
    /**
     * 保存用户授权信息
     * @param record 用户实体
     * @return int 0：失败；1：成功
     */
    int saveUserAuthoriza(SysUser record);
    
    /**
     * 初始化用户密码
     * @param record 用户实体
     * @param currentUser 当前登录用户
     * @return int 0：失败；1：成功
     */
    int initializaPassword(SysUser record, SysUser currentUser);
}
