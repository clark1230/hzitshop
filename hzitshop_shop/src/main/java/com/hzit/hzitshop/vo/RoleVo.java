package com.hzit.hzitshop.vo;

/**
 * 
 * @author xianyaoji
 */
public class RoleVo {
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
	private String 角色描述;
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
	 * 角色名称
	 * @param roleName
	 */
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	
    /**
     * 角色名称
     * @return String
     */	
    public String getRoleName(){
    	return roleName;
    }
	/**
	 * 角色描述
	 * @param 角色描述
	 */
	public void set角色描述(String 角色描述){
		this.角色描述 = 角色描述;
	}
	
    /**
     * 角色描述
     * @return String
     */	
    public String get角色描述(){
    	return 角色描述;
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
     * @return java.util.Date
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
     * @return String
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
     * @return java.util.Date
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
     * @return String
     */	
    public String getUpdateBy(){
    	return updateBy;
    }
}