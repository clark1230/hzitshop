package com.hzit.hzitshop.entity;

/**
 * 
 * @author xianyaoji
 */
public class OrgRole {
	/**
	 *  编号
	 */
	private Integer id;
	/**
	 *  组织编号
	 */
	private Integer orgId;
	/**
	 *  角色编号
	 */
	private Integer roleId;
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
}