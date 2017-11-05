package com.hzit.hzitshop.entity;

/**
 * 
 * @author xianyaoji
 */
public class RolePermission {
	/**
	 *  编号
	 */
	private Integer id;
	/**
	 *  角色编号
	 */
	private Integer roleId;
	/**
	 *  权限编号
	 */
	private Integer permissionId;

	public RolePermission(Integer roleId, Integer permissionId) {
		this.roleId = roleId;
		this.permissionId = permissionId;
	}

	public RolePermission() {
	}

	/**
	 * 编号
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
    /**
     * 编号
     * @return
     */	
    public Integer getId(){
    	return id;
    }
	/**
	 * 角色编号
	 * @param roleId
	 */
	public void setRoleId(Integer roleId){
		this.roleId = roleId;
	}
	
    /**
     * 角色编号
     * @return
     */	
    public Integer getRoleId(){
    	return roleId;
    }
	/**
	 * 权限编号
	 * @param permissionId
	 */
	public void setPermissionId(Integer permissionId){
		this.permissionId = permissionId;
	}
	
    /**
     * 权限编号
     * @return
     */	
    public Integer getPermissionId(){
    	return permissionId;
    }
}