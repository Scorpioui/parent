package cn.middle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.middle.pojo.SysUser;
import cn.middle.util.CrudDao;

public interface SysUserMapper extends CrudDao<SysUser>{

    /**
     * 根据登录名，密码获取用户信息
     * @param record 用户实体
     * @return SysUser 用户实体
     */
    SysUser selectByUserCodePassword(SysUser record);
    
    /**
     * 根据登录名，密码获取用户信息
     * @param userCode 登录名
     * @return SysUser 用户实体
     */
    SysUser findByUserCode(String userCode);
    
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
     * @param sysUser 用户实体
     * @param pageSize 每页的条数
     * @param pageIndex 当前页数
     * @return List<SysUser> 返回用户list集合
     */
    List<SysUser> findPage(@Param("sysUser")SysUser sysUser, @Param("pageSize")int pageSize, @Param("pageIndex")int pageIndex);
    
    /**
     * 查询用户总数量
     * @param sysUser 用户实体
     * @return int 用户总数量
     */
    int getCount(@Param("sysUser")SysUser sysUser);
    
    /**
     * 根据用户ID删除用户信息
     * @param sysUser 用户实体
     * @return msg > 0：成功；msg < 0：失败
     */
    int deleteByUserId(SysUser record);
    
    /**
     * 初始化用户密码
     * @param record 用户实体
     * @param currentUser 当前登录用户
     * @return int 0：失败；1：成功
     */
    int initializaPassword(SysUser record);
}