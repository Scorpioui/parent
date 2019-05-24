package cn.middle.service;

import cn.middle.pojo.SysUser;

/**
 * 登录Service
 */
public interface LoginService {
    
    /**
     * 根据登录名，密码获取用户信息
     * @param record 用户实体
     * @return SysUser 用户实体
     */
    SysUser selectByUserCodePassword(SysUser record);
    
    /**
     * 根据登录名查询用户是否存在
     * @param userCode 登录名
     * @return SysUser 用户实体
     */
    SysUser findByUserCode(String userCode);
    
}
