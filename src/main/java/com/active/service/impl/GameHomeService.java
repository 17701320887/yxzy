package com.active.service.impl;

import com.active.dao.GameHomeMapper;
import com.active.model.GameHome;
import com.active.service.IGameHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by chenqi on 2018/3/13.
 */
@Service
public class GameHomeService implements IGameHomeService{

    @Autowired
    private GameHomeMapper gameHomeMapper;


    @Override
    public void save(GameHome gameHome) {
        gameHomeMapper.save(gameHome);
    }

    @Override
    public GameHome findByPwd(String gamePwd) {
        return gameHomeMapper.findByPwd(gamePwd);
    }

    @Override
    public GameHome findByName(String name) {
        return gameHomeMapper.findByName(name);
    }
}
