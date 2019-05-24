package cn.middle.pojo;

/**
 * 用户角色关系实体
 * @author Admin
 *
 */
public class SysUserRole {

    /**
     * 主键ID
     */
    private String sysUserRoleId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 角色ID
     */
    private String roleId;

    public String getSysUserRoleId() {
        return sysUserRoleId;
    }

    public void setSysUserRoleId(String sysUserRoleId) {
        this.sysUserRoleId = sysUserRoleId == null ? null : sysUserRoleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}