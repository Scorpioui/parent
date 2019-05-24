package cn.middle.pojo;

/**
 * 用户部门关系实体
 */
public class SysUserOffice {

    /**
     * 主键ID
     */
    private String sysUserOfficeId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 部门ID
     */
    private String officeId;

    public String getSysUserOfficeId() {
        return sysUserOfficeId;
    }

    public void setSysUserOfficeId(String sysUserOfficeId) {
        this.sysUserOfficeId = sysUserOfficeId == null ? null : sysUserOfficeId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId == null ? null : officeId.trim();
    }
}