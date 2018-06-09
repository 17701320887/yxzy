package com.active.service;

import com.active.model.GameHome;

import java.util.List;

/**
 * Created by chenqi on 2018/3/13.
 */
public interface IGameHomeService {
    void save(GameHome gameHome);
    GameHome findByPwd(String gamePwd);
    GameHome findByName(String name);
}
