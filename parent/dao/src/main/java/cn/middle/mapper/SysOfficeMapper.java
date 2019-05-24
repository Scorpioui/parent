package cn.middle.mapper;

import java.util.List;

import cn.middle.pojo.SysOffice;
import cn.middle.util.CrudDao;

public interface SysOfficeMapper extends CrudDao<SysOffice>{

    /**
     * 根据当前登录用户获取所属分公司机构对象
     * @param record 当前登录用户
     * @return SysOffice 所属分公司机构对象
     */
    SysOffice getOffice(SysOffice record);
    
    /**
     * 根据条件查询部门信息 
     * @param record 部门实体
     * @return List<SysOffice> 返回部门list集合
     */
    List<SysOffice> findList(SysOffice record);
    
    /**
     * 查询部门下用户数量
     * @param record 部门实体
     * @return int 返回部门下用户数量
     */
    int getUserCount(SysOffice record);
    
    /**
     * 查询当前部门下部门数量
     * @param record 部门实体
     * @return int 返回部门下部门数量
     */
    int getOfficeCount(SysOffice record);
    
    /**
     * 根据部门ID删除部门信息
     * @param record 部门实体
     * @return int 0：失败；1：成功
     */
    int deleteByOfficeId(SysOffice record);
    
}