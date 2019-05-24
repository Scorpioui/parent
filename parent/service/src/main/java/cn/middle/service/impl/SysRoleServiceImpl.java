package cn.middle.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.middle.mapper.SysRoleMapper;
import cn.middle.mapper.SysRoleMenuMapper;
import cn.middle.pojo.SysRole;
import cn.middle.pojo.SysRoleMenu;
import cn.middle.pojo.SysUser;
import cn.middle.service.SysRoleService;
import cn.middle.util.StringUtils;
import cn.middle.util.UuidGeneration;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService{

    /**
     * 角色Dao
     */
    @Resource
    private SysRoleMapper sysRoleMapper;
    
    /**
     * 角色菜单Dao
     */
    @Resource
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int deleteByPrimaryKey(String roleId) {
        return sysRoleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public int insertSelective(SysRole record) {
        return sysRoleMapper.insertSelective(record);
    }

    @Override
    public SysRole selectByPrimaryKey(String roleId) {
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysRole> findList(SysRole record) {
        return sysRoleMapper.findList(record);
    }

    @Override
    public List<SysRole> selectRoleByUserId(SysRole record) {
        return sysRoleMapper.selectRoleByUserId(record);
    }

    @Override
    public List<SysRole> findPage(SysRole record, int pageSize, int pageIndex) {
        return sysRoleMapper.findPage(record, pageSize, pageIndex);
    }

    @Override
    public int getCount(SysRole record) {
        return sysRoleMapper.getCount(record);
    }

    @Override
    public int save(SysRole record, SysUser currentUser) {

        if (StringUtils.isNotBlank(record.getRoleId())){
            record.setUpdateUser(currentUser.getUserId());
            record.setUpdateTime(new Date());
            record.setDelFlag("0");
            return sysRoleMapper.updateByPrimaryKeySelective(record);
        } else {
            record.setRoleId(UuidGeneration.getUUID());
            record.setCreateUser(currentUser.getUserId());
            record.setCreateTime(new Date());
            record.setDelFlag("0");
            return sysRoleMapper.insertSelective(record);
        }
    }

    @Override
    public int deleteByRoleId(SysRole record, SysUser currentUser) {

        record.setUpdateUser(currentUser.getUserId());
        record.setUpdateTime(new Date());
        record.setDelFlag("1");
        return sysRoleMapper.deleteByRoleId(record);
    }

    @Override
    @Transactional(rollbackFor=Exception.class) // 加入事务，如果出现异常，则回滚事务
    public int saveRoleAuthoriza(SysRole record) {
        
        if(StringUtils.isNotBlank(record.getRoleId())) {
            
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRoleId(record.getRoleId());
            // 删除所有的角色菜单关系
            sysRoleMenuMapper.deleteByRoleId(sysRoleMenu);
            
            // 重新维护角色菜单关系
            List<SysRoleMenu> voList = new ArrayList<SysRoleMenu>();
            String strs[] = null;
            if(StringUtils.isNotBlank(record.getMenuIds())) {
                strs = record.getMenuIds().split(",");
            }
            if(strs != null && strs.length > 0) {
                for(int i = 0 ; i < strs.length ; i ++) {
                    SysRoleMenu temp = new SysRoleMenu();
                    temp.setSysRoleMenuId(UuidGeneration.getUUID());
                    temp.setRoleId(record.getRoleId());
                    temp.setMenuId(strs[i]);
                    voList.add(temp);
                }
            }
            if(voList != null && voList.size() > 0) {
                sysRoleMenuMapper.insertSysRoleMenus(voList);
            }
            return 1;
        }
        return 0;
    }
    
}
