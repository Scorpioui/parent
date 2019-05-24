package cn.middle.util;

import java.util.List;

/**
 * 抽象类CrudService
 * @ClassName: CrudService
 */
public interface CrudService<T> {
    
    /**
     * 插入数据
     * @param entity
     * @return
     */
    public int insertSelective(T entity);
    
    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T selectByPrimaryKey(String id);
    
    /**
     * 更新数据
     * @param entity
     * @return
     */
    public int updateByPrimaryKeySelective(T entity);
    
    /**
     * 根据ID删除数据
     * @param id
     * @return
     */
    public int deleteByPrimaryKey(String id);

    /**
     * 查询数据列表
     * @param entity
     * @return
     */
    public List<T> findList(T entity);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象:<br/>
     * entity.setPageIndex();<br/>
     * entity.setPageSize();
     * @param entity
     * @return
     */
    public List<T> findPage(T entity);

    /**
     * 查询数据条数，配合分页功能使用
     * @param entity
     * @return
     */
    public int getCount(T entity);

}
