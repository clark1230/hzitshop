package com.hzit.hzitshop.vo;

import com.hzit.hzitshop.entity.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xianyaoji
 */
public class PermissionVo {
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

	private String name;
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

	private List<PermissionVo>  children = new ArrayList<>();

	/**
	 * 权限编号，主键，自增长
	 * @param id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
    /**
     * 权限编号，主键，自增长
     * @return Integer
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
     * @return Integer
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
     * @return String
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
     * @return String
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
     * @return String
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
     * @return String
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
     * @return String
     */	
    public String getDescription(){
    	return description;
    }


	public String getName() {
		return title;
	}

	public List<PermissionVo> getChildren() {
		return children;
	}

	public void setChildren(List<PermissionVo> children) {
		this.children = children;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
}