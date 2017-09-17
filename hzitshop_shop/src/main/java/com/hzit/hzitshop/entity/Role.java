package com.hzit.hzitshop.entity;

/**
 * 
 * @author xianyaoji
 */
public class Role {
	/**
	 *  角色编号
	 */
	private Integer roleId;
	/**
	 *  角色名称
	 */
	private String roleName;
	/**
	 *  角色描述
	 */
	private String description;
	/**
	 *  录入时间
	 */
	private java.util.Date createTime;
	/**
	 *  录入人
	 */
	private String createBy;
	/**
	 *  修改时间
	 */
	private java.util.Date updateTime;
	/**
	 *  修改人
	 */
	private String updateBy;
	/**
	 *  是否禁用: 0:表示禁用,1:表示启用,默认启用
	 */
	private String isLock="1";
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
	 * 角色名称
	 * @param roleName
	 */
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
    /**
     * 角色名称
     * @return
     */	
    public String getRoleName(){
    	return roleName;
    }
	/**
	 * 角色描述
	 * @param description
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
    /**
     * 角色描述
     * @return
     */	
    public String getDescription(){
    	return description;
    }
	/**
	 * 录入时间
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	
    /**
     * 录入时间
     * @return
     */	
    public java.util.Date getCreateTime(){
    	return createTime;
    }
	/**
	 * 录入人
	 * @param createBy
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	
    /**
     * 录入人
     * @return
     */	
    public String getCreateBy(){
    	return createBy;
    }
	/**
	 * 修改时间
	 * @param updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	
    /**
     * 修改时间
     * @return
     */	
    public java.util.Date getUpdateTime(){
    	return updateTime;
    }
	/**
	 * 修改人
	 * @param updateBy
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	
    /**
     * 修改人
     * @return
     */	
    public String getUpdateBy(){
    	return updateBy;
    }

	public String getIsLock() {
		return isLock;
	}

	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}
}