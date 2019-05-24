package cn.middle.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.middle.pojo.SysUser;
import cn.middle.service.SysUserService;

/**
 * 
 */
@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private SysUserService userService;

    @RequestMapping("index")
    public List<SysUser> index() {
        SysUser user = new SysUser();
        user.setDelFlag("0");
        List<SysUser> all = userService.findList(user);
        return all;
    }
    
}
