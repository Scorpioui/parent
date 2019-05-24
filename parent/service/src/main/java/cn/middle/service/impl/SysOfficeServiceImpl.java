package cn.middle.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.middle.mapper.SysOfficeMapper;
import cn.middle.pojo.SysOffice;
import cn.middle.pojo.SysUser;
import cn.middle.service.SysOfficeService;
import cn.middle.util.StringUtils;
import cn.middle.util.UuidGeneration;

@Service("sysOfficeService")
public class SysOfficeServiceImpl implements SysOfficeService{

    /**
     * 机构Dao
     */
    @Resource
    private SysOfficeMapper sysOfficeMapper;

    @Override
    public int deleteByPrimaryKey(String officeId) {
        return sysOfficeMapper.deleteByPrimaryKey(officeId);
    }

    @Override
    public int insertSelective(SysOffice record) {
        return sysOfficeMapper.insertSelective(record);
    }

    @Override
    public SysOffice selectByPrimaryKey(String officeId) {
        return sysOfficeMapper.selectByPrimaryKey(officeId);
    }

    @Override
    public int updateByPrimaryKeySelective(SysOffice record) {
        return sysOfficeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<SysOffice> findList(SysOffice record) {
        return sysOfficeMapper.findList(record);
    }

    @Override
    public int save(SysOffice record, SysUser currentUser) {
        
        if (StringUtils.isNotBlank(record.getOfficeId())){
            record.setUpdateUser(currentUser.getUserId());
            record.setUpdateTime(new Date());
            record.setDelFlag("0");
            return sysOfficeMapper.updateByPrimaryKeySelective(record);
        } else {
            record.setOfficeId(UuidGeneration.getUUID());
            record.setCreateUser(currentUser.getUserId());
            record.setCreateTime(new Date());
            record.setDelFlag("0");
            return sysOfficeMapper.insertSelective(record);
        }
    }

    @Override
    @Transactional(rollbackFor=Exception.class) // 加入事务，如果出现异常，则回滚事务
    public int deleteByOfficeId(SysOffice record, SysUser currentUser) {
        
        SysOffice vo = new SysOffice();
        vo.setDelFlag("0");
        vo.setOfficeId(record.getOfficeId());
        Integer userCount = sysOfficeMapper.getUserCount(vo);
        Integer officeCount = sysOfficeMapper.getOfficeCount(vo);
        
        if(userCount > 0) {
            // 当前部门下还有用户存在，不允许删除该部门
            return -1;
        } else if (officeCount > 0) {
            // 当前部门下还有部门存在， 不允许删除该部门
            return -2;
        } else {
            record.setUpdateUser(currentUser.getUserId());
            record.setUpdateTime(new Date());
            record.setDelFlag("1");
            return sysOfficeMapper.deleteByOfficeId(record);
        }
    }
    
}
