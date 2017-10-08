package com.hzit.hzitshop.entity;

/**
 * 
 * @author xianyaoji
 */
public class Permission {
	/**
	 *  权限编号，主键，自增长
	 */
	private Integer id;
	/**
	 *  权限的父级编号
	 */
	private Integer pid;
	/**
	 *  权限名称
	 */
	private String title;
	/**
	 *  权限的图标
	 */
	private String icon;
	/**
	 *  权限地址,需要保护的资源
	 */
	private String url;
	/**
	 *  是否展开，true:展开,false:不展开
	 */
	private String spread;
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
	 *  修改人
	 */
	private String updateBy;
	/**
	 *  修改时间
	 */
	private java.util.Date updateTime;
	/**
	 * 菜单级别
	 */
	private String level;
	/**
	 * 权限编号，主键，自增长
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
    /**
     * 权限编号，主键，自增长
     * @return
     */	
    public Integer getId(){
    	return id;
    }
	/**
	 * 权限的父级编号
	 * @param pid
	 */
	public void setPid(Integer pid){
		this.pid = pid;
	}
	
    /**
     * 权限的父级编号
     * @return
     */	
    public Integer getPid(){
    	return pid;
    }
	/**
	 * 权限名称
	 * @param title
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
    /**
     * 权限名称
     * @return
     */	
    public String getTitle(){
    	return title;
    }
	/**
	 * 权限的图标
	 * @param icon
	 */
	public void setIcon(String icon){
		this.icon = icon;
	}
	
    /**
     * 权限的图标
     * @return
     */	
    public String getIcon(){
    	return icon;
    }
	/**
	 * 权限地址,需要保护的资源
	 * @param url
	 */
	public void setUrl(String url){
		this.url = url;
	}
	
    /**
     * 权限地址,需要保护的资源
     * @return
     */	
    public String getUrl(){
    	return url;
    }
	/**
	 * 是否展开，true:展开,false:不展开
	 * @param spread
	 */
	public void setSpread(String spread){
		this.spread = spread;
	}
	
    /**
     * 是否展开，true:展开,false:不展开
     * @return
     */	
    public String getSpread(){
    	return spread;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}