package com.hzit.hzitshop.vo;

/**
 * 
 * @author xianyaoji
 */
public class UserOrgVo {
	/**
	 *  编号
	 */
	private Integer id;
	/**
	 *  组织编号
	 */
	private Integer orgId;
	/**
	 *  用户编号
	 */
	private Integer userId;
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
	 * 用户编号
	 * @param userId
	 */
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	
    /**
     * 用户编号
     * @return Integer
     */	
    public Integer getUserId(){
    	return userId;
    }
}