package com.hzit.hzitshop.vo;

/**
 * 
 * @author xianyaoji
 */
public class OrgVo {
	/**
	 *  组织编号
	 */
	private Integer orgId;
	/**
	 *  父级编号
	 */
	private Integer orgParentId;
	/**
	 *  父级代码
	 */
	private String orgCode;
	/**
	 *  组织名称
	 */
	private String name;
	/**
	 *  描述
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
	/**
	 * 父级编号
	 * @param orgParentId
	 */
	public void setOrgParentId(Integer orgParentId){
		this.orgParentId = orgParentId;
	}
	
    /**
     * 父级编号
     * @return Integer
     */	
    public Integer getOrgParentId(){
    	return orgParentId;
    }
	/**
	 * 父级代码
	 * @param orgCode
	 */
	public void setOrgCode(String orgCode){
		this.orgCode = orgCode;
	}
	
    /**
     * 父级代码
     * @return String
     */	
    public String getOrgCode(){
    	return orgCode;
    }
	/**
	 * 组织名称
	 * @param name
	 */
	public void setName(String name){
		this.name = name;
	}
	
    /**
     * 组织名称
     * @return String
     */	
    public String getName(){
    	return name;
    }
	/**
	 * 描述
	 * @param description
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
    /**
     * 描述
     * @return String
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