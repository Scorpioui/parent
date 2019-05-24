package cn.middle.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.middle.mapper.SysMenuMapper;
import cn.middle.pojo.SysMenu;
import cn.middle.pojo.SysUser;
import cn.middle.service.SysMenuService;
import cn.middle.util.StringUtils;
import cn.middle.util.UuidGeneration;

@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService{

    /**
     * 菜单Dao
     */
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public int deleteByPrimaryKey(String menuId) {
        return sysMenuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public int insertSelective(SysMenu record) {
        return sysMenuMapper.insertSelective(record);
    }

    @Override
    public SysMenu selectByPrimaryKey(String menuId) {
        return sysMenuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysMenu record) {
        return sysMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysMenu> findList(SysMenu record) {
        return sysMenuMapper.findList(record);
    }

    @Override
    public int save(SysMenu record, SysUser currentUser) {
        
        if (StringUtils.isNotBlank(record.getMenuId())){
            record.setUpdateUser(currentUser.getUserId());
            record.setUpdateTime(new Date());
            record.setDelFlag("0");
            return sysMenuMapper.updateByPrimaryKeySelective(record);
        } else {
            record.setMenuId(UuidGeneration.getUUID());
            record.setCreateUser(currentUser.getUserId());
            record.setCreateTime(new Date());
            record.setDelFlag("0");
            return sysMenuMapper.insertSelective(record);
        }
    }

    @Override
    @Transactional(rollbackFor=Exception.class) // 加入事务，如果出现异常，则回滚事务
    public int deleteByMenuId(SysMenu record, SysUser currentUser) {
        
        SysMenu vo = new SysMenu();
        vo.setDelFlag("0");
        vo.setMenuId(record.getMenuId());
        Integer menuCount = sysMenuMapper.getMenuCount(vo);
        
        if(menuCount > 0) {
            // 当前菜单下还有子菜单存在，不允许删除该菜单
            return -1;
        } else {
            record.setUpdateUser(currentUser.getUserId());
            record.setUpdateTime(new Date());
            record.setDelFlag("1");
            return sysMenuMapper.deleteByMenuId(record);
        }
    }

    @Override
    public List<SysMenu> selectMenuByUserId(SysMenu record) {
        return sysMenuMapper.selectMenuByUserId(record);
    }

    @Override
    public List<SysMenu> findListByRoleId(SysMenu record) {
        return sysMenuMapper.findListByRoleId(record);
    }
    
}
