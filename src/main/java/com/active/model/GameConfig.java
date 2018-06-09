package com.active.model;

import com.active.common.bean.BaseEntity;

public class GameConfig extends BaseEntity{
    private Long homeUserNum;

    public Long getHomeUserNum() {
        return homeUserNum;
    }

    public void setHomeUserNum(Long homeUserNum) {
        this.homeUserNum = homeUserNum;
    }
}
