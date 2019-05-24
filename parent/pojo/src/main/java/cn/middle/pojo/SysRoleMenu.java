package cn.middle.pojo;

/**
 * 角色菜单关系实体
 */
public class SysRoleMenu {

    /**
     * 主键ID
     */
    private String sysRoleMenuId;
    /**
     * 角色ID
     */
    private String roleId;
    /**
     * 菜单ID
     */
    private String menuId;

    public String getSysRoleMenuId() {
        return sysRoleMenuId;
    }

    public void setSysRoleMenuId(String sysRoleMenuId) {
        this.sysRoleMenuId = sysRoleMenuId == null ? null : sysRoleMenuId.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId == null ? null : menuId.trim();
    }
}