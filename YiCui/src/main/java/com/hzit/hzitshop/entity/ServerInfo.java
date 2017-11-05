package com.hzit.hzitshop.entity;

/**
 * 服务器实体类
 */
public class ServerInfo {
    private String vendor;//供应商
    private String base;
    private String compiler;//编译器
    private String os;//操作系统版本
    private String version;//jdk版本
    private String language;//语言
    private String path;//环境变量
    private String timezone;//时区
    private String encoding;//编码
    private long freeMemory;//空余内存
    private long maxMemory;//最大内存
    private long totalMemory;//总内存

    public ServerInfo() {
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getCompiler() {
        return compiler;
    }

    public void setCompiler(String compiler) {
        this.compiler = compiler;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "vendor='" + vendor + '\'' +
                ", base='" + base + '\'' +
                ", compiler='" + compiler + '\'' +
                ", os='" + os + '\'' +
                ", version='" + version + '\'' +
                ", language='" + language + '\'' +
                ", path='" + path + '\'' +
                ", timezone='" + timezone + '\'' +
                ", encoding='" + encoding + '\'' +
                ", freeMemory=" + freeMemory +
                ", maxMemory=" + maxMemory +
                ", totalMemory=" + totalMemory +
                '}';
    }
}
