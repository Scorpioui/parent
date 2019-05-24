package cn.middle.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.middle.mapper.SysUserMapper;
import cn.middle.pojo.SysUser;
import cn.middle.service.LoginService;

/**
 * 用户信息的操作实现类
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {
    
    /**
     * 系统用户实体
     */
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 查询用户信息
     * @param managingUser 需要查询的用户信息的条件对象
     * @return 查询到的用户信息记录
     */
    @Override
    public SysUser selectByUserCodePassword(SysUser record) {
        return sysUserMapper.selectByUserCodePassword(record);
    }

    @Override
    public SysUser findByUserCode(String userCode) {
        return sysUserMapper.findByUserCode(userCode);
    }

}
