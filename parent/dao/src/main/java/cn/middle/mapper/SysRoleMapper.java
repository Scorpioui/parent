package cn.middle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.middle.pojo.SysRole;
import cn.middle.util.CrudDao;

public interface SysRoleMapper extends CrudDao<SysRole>{

    /**
     * 根据条件查询角色列表
     * @param record 角色实体
     * @return List<SysRole> 返回角色list集合
     */
    List<SysRole> findList(SysRole record);
    
    /**
     * 根据用户ID查询所拥有的角色信息
     * @param record 角色实体
     * @return List<SysRole> 返回角色list集合
     */
    List<SysRole> selectRoleByUserId(SysRole record);
    
    /**
     * 查询角色分页数据
     * @param record 角色实体
     * @param pageSize  每页的条数
     * @param pageIndex  当前页数
     * @return List<SysRole> 返回订单list集合
     */
    List<SysRole> findPage(@Param("sysRole")SysRole record, @Param("pageSize")int pageSize, @Param("pageIndex")int pageIndex);
    
    /**
     * 查询角色总数量
     * @param record 角色实体
     * @return int 角色总数量
     */
    int getCount(@Param("sysRole")SysRole record);
    
    /**
     * 根据角色ID删除角色信息
     * @param record 角色实体
     * @return 0：失败；1：成功
     */
    int deleteByRoleId(SysRole record);
    
}