package com.hzit.hzitshop.entity;

/**
 * 
 * @author xianyaoji
 */
public class LogEntity {
	/**
	 *  主键
	 */
	private Integer logId;
	/**
	 *  用户名
	 */
	private String username;
	/**
	 *  模块
	 */
	private String module;
	/**
	 *  方法
	 */
	private String method;
	/**
	 *  响应时间
	 */
	private String responseDate;
	/**
	 *  ip地址
	 */
	private String ip;
	/**
	 *  操作时间
	 */
	private String date;
	/**
	 *  执行结果:成功,失败
	 */
	private String commit;
	/**
	 * 主键
	 * @param logId
	 */
	public void setLogId(Integer logId){
		this.logId = logId;
	}
	
    /**
     * 主键
     * @return
     */	
    public Integer getLogId(){
    	return logId;
    }
	/**
	 * 用户名
	 * @param username
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
    /**
     * 用户名
     * @return
     */	
    public String getUsername(){
    	return username;
    }
	/**
	 * 模块
	 * @param module
	 */
	public void setModule(String module){
		this.module = module;
	}
	
    /**
     * 模块
     * @return
     */	
    public String getModule(){
    	return module;
    }
	/**
	 * 方法
	 * @param method
	 */
	public void setMethod(String method){
		this.method = method;
	}
	
    /**
     * 方法
     * @return
     */	
    public String getMethod(){
    	return method;
    }
	/**
	 * 响应时间
	 * @param responseDate
	 */
	public void setResponseDate(String responseDate){
		this.responseDate = responseDate;
	}
	
    /**
     * 响应时间
     * @return
     */	
    public String getResponseDate(){
    	return responseDate;
    }
	/**
	 * ip地址
	 * @param ip
	 */
	public void setIp(String ip){
		this.ip = ip;
	}
	
    /**
     * ip地址
     * @return
     */	
    public String getIp(){
    	return ip;
    }
	/**
	 * 操作时间
	 * @param date
	 */
	public void setDate(String date){
		this.date = date;
	}
	
    /**
     * 操作时间
     * @return
     */	
    public String getDate(){
    	return date;
    }
	/**
	 * 执行结果:成功,失败
	 * @param commit
	 */
	public void setCommit(String commit){
		this.commit = commit;
	}
	
    /**
     * 执行结果:成功,失败
     * @return
     */	
    public String getCommit(){
    	return commit;
    }
}