package com.hzit.hzitshop.vo;

/**
 * 
 * @author xianyaoji
 */
public class OrgPermissionVo {
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
     * @return Integer
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
     * @return Integer
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
     * @return Integer
     */	
    public Integer getOrgId(){
    	return orgId;
    }
}