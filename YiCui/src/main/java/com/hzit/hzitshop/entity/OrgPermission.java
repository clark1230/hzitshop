package com.hzit.hzitshop.entity;

/**
 * 
 * @author xianyaoji
 */
public class OrgPermission {
	/**
	 *  编号
	 */
	private Integer id;
	/**
	 *  权限编号
	 */
	private Integer permissionId;
	/**
	 *  组织编号
	 */
	private Integer orgId;
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
	/**
	 * 组织编号
	 * @param orgId
	 */
	public void setOrgId(Integer orgId){
		this.orgId = orgId;
	}
	
    /**
     * 组织编号
     * @return
     */	
    public Integer getOrgId(){
    	return orgId;
    }
}