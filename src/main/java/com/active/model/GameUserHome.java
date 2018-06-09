package com.active.model;

import com.active.common.bean.BaseEntity;

import java.util.Date;


/**
 * Created by chenqi on 2018/3/13.
 */
public class GameUserHome extends BaseEntity {

    /**
     * 用户id
     */
    private Long userId;
    /**
     * 战队id
     */
    private Long homeId;
    /**
     * 加入时间
     */
    private Date joinTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
