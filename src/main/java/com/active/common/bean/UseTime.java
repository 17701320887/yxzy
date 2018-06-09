package com.active.common.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by on 2017/11/2.
 */
public class UseTime implements Serializable {

    private static final long serialVersionUID = -1319968876969477176L;
    /**
     * 类名
     */
    private String className;
    /**
     * 方法
     */
    private String method;
    /**
     * 耗时
     */
    private Long useTime;
    /**
     * 记录时间
     */
    private Date noteTime;

    private String ip;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Long getUseTime() {
        return useTime;
    }

    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    public UseTime(String className, String method, Long useTime,Date noteTime,String ip) {
        this.className = className;
        this.method = method;
        this.useTime = useTime;
        this.noteTime = noteTime;
        this.ip = ip;
    }

    public Date getNoteTime() {
        return noteTime;
    }

    public void setNoteTime(Date noteTime) {
        this.noteTime = noteTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public UseTime() {
    }
}
