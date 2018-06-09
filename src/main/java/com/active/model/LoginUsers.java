package com.active.model;

import com.active.common.bean.BaseEntity;

import java.util.Date;


/**
 * Created by chenqi on 2018/3/13.
 */
public class LoginUsers extends BaseEntity {

    /**
     * 用户名
     */
    private String username;
    /**
     * 注册手机号
     */
    private String mobile;
    /**
     * 最后一次登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后一次登录iP
     */
    private String lastIp;
    /**
     * 登录密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
