package com.hzit.hzitshop.vo;

/**
 * 
 * @author xianyaoji
 */
public class RolePermissionVo {
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
	/**
	 * 编号
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
    /**
     * 编号
     * @return Integer
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
     * @return Integer
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
     * @return Integer
     */	
    public Integer getPermissionId(){
    	return permissionId;
    }
}