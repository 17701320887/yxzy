package com.active.model;

public class GameUserDto extends GameUser {
    private String name;

    private Long homeUserId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHomeUserId() {
        return homeUserId;
    }

    public void setHomeUserId(Long homeUserId) {
        this.homeUserId = homeUserId;
    }
}
