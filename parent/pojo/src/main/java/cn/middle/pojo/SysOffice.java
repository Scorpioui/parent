package cn.middle.pojo;

import java.util.Date;

/**
 * 部门实体
 */
public class SysOffice {

    /**
     * 部门ID
     */
    private String officeId;
    /**
     * 部门编码
     */
    private String officeCode;
    /**
     * 部门名称
     */
    private String officeName;
    /**
     * 上级部门ID
     */
    private String parentOfficeId;
    /**
     * 所有上级ID
     */
    private String parentOfficeIds;
    /**
     * 部门级别
     */
    private String officeLevel;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改人
     */
    private String updateUser;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 删除标识：0：正常；1：已删除
     */
    private String delFlag;
    
    /************************查询字段************************/
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 上级部门名称
     */
    private String parentOfficeName;

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId == null ? null : officeId.trim();
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode == null ? null : officeCode.trim();
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName == null ? null : officeName.trim();
    }

    public String getParentOfficeId() {
        return parentOfficeId;
    }

    public void setParentOfficeId(String parentOfficeId) {
        this.parentOfficeId = parentOfficeId == null ? null : parentOfficeId.trim();
    }

    public String getParentOfficeIds() {
        return parentOfficeIds;
    }

    public void setParentOfficeIds(String parentOfficeIds) {
        this.parentOfficeIds = parentOfficeIds;
    }

    public String getOfficeLevel() {
        return officeLevel;
    }

    public void setOfficeLevel(String officeLevel) {
        this.officeLevel = officeLevel == null ? null : officeLevel.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getParentOfficeName() {
        return parentOfficeName;
    }

    public void setParentOfficeName(String parentOfficeName) {
        this.parentOfficeName = parentOfficeName;
    }
    
}