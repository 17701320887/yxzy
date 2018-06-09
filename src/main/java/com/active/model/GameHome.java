package com.active.model;

import com.active.common.bean.BaseEntity;

import java.util.Date;


/**
 * Created by chenqi on 2018/3/13.
 */
public class GameHome extends BaseEntity {
    /**
     * 队长id
     */
    private Long userId;
    /**
     * 战队口令
     */
    private String gamePwd;
    /**
     * 战队名称
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;

    public String getGamePwd() {
        return gamePwd;
    }

    public void setGamePwd(String gamePwd) {
        this.gamePwd = gamePwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
