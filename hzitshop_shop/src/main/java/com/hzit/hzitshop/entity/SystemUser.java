package com.hzit.hzitshop.entity;

/**
 * 
 * @author xianyaoji
 */
public class SystemUser {
	/**
	 *  用户编号
	 */
	private Integer userId;
	/**
	 *  用户名称
	 */
	private String userName;
	/**
	 *  年龄
	 */
	private Integer age;
	/**
	 *  性别
	 */
	private String gender;
	/**
	 *  qq号
	 */
	private String qq;
	/**
	 *  邮箱
	 */
	private String email;
	/**
	 *  是否禁用: 0:表示禁用,1:表示启用,默认启用
	 */
	private String isLock="1";
	/**
	 *  用户地址
	 */
	private String address;
	/**
	 *  部门名称
	 */
	private String dept;
	/**
	 *  岗位编号
	 */
	private String jobId;
	/**
	 *  公司名称
	 */
	private String company;
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
	 * 用户编号
	 * @param userId
	 */
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	
    /**
     * 用户编号
     * @return
     */	
    public Integer getUserId(){
    	return userId;
    }
	/**
	 * 用户名称
	 * @param userName
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}
	
    /**
     * 用户名称
     * @return
     */	
    public String getUserName(){
    	return userName;
    }
	/**
	 * 年龄
	 * @param age
	 */
	public void setAge(Integer age){
		this.age = age;
	}
	
    /**
     * 年龄
     * @return
     */	
    public Integer getAge(){
    	return age;
    }
	/**
	 * 性别
	 * @param gender
	 */
	public void setGender(String gender){
		this.gender = gender;
	}
	
    /**
     * 性别
     * @return
     */	
    public String getGender(){
    	return gender;
    }
	/**
	 * qq号
	 * @param qq
	 */
	public void setQq(String qq){
		this.qq = qq;
	}
	
    /**
     * qq号
     * @return
     */	
    public String getQq(){
    	return qq;
    }
	/**
	 * 邮箱
	 * @param email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
    /**
     * 邮箱
     * @return
     */	
    public String getEmail(){
    	return email;
    }
	/**
	 * 是否禁用: 0:表示禁用,1:表示启用,默认启用
	 * @param isLock
	 */
	public void setIsLock(String isLock){
		this.isLock = isLock;
	}
	
    /**
     * 是否禁用: 0:表示禁用,1:表示启用,默认启用
     * @return
     */	
    public String getIsLock(){
    	return isLock;
    }
	/**
	 * 用户地址
	 * @param address
	 */
	public void setAddress(String address){
		this.address = address;
	}
	
    /**
     * 用户地址
     * @return
     */	
    public String getAddress(){
    	return address;
    }
	/**
	 * 部门名称
	 * @param dept
	 */
	public void setDept(String dept){
		this.dept = dept;
	}
	
    /**
     * 部门名称
     * @return
     */	
    public String getDept(){
    	return dept;
    }
	/**
	 * 岗位编号
	 * @param jobId
	 */
	public void setJobId(String jobId){
		this.jobId = jobId;
	}
	
    /**
     * 岗位编号
     * @return
     */	
    public String getJobId(){
    	return jobId;
    }
	/**
	 * 公司名称
	 * @param company
	 */
	public void setCompany(String company){
		this.company = company;
	}
	
    /**
     * 公司名称
     * @return
     */	
    public String getCompany(){
    	return company;
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
}