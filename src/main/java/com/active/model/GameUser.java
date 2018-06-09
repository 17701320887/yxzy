package com.active.model;

import com.active.common.bean.BaseEntity;

import java.util.Date;


/**
 * Created by chenqi on 2018/3/13.
 */
public class GameUser extends BaseEntity {

    /**
     * 火币uid
     */
    private String token;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户IP
     * @return
     */
    private String userIp;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }
}
