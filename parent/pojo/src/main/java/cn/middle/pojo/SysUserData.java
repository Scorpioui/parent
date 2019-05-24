package cn.middle.pojo;

public class SysUserData {
    
    /**
     * 用户数据权限关系ID
     */
    private String sysUserDataId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 数据权限ID
     */
    private String dataPermissionsId;
    
    /**
     * 激活标识
     */
    private String delFlag;

    public String getSysUserDataId() {
        return sysUserDataId;
    }

    public void setSysUserDataId(String sysUserDataId) {
        this.sysUserDataId = sysUserDataId == null ? null : sysUserDataId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDataPermissionsId() {
        return dataPermissionsId;
    }

    public void setDataPermissionsId(String dataPermissionsId) {
        this.dataPermissionsId = dataPermissionsId == null ? null : dataPermissionsId.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
    
}