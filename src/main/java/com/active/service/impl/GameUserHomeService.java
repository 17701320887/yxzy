package com.active.service.impl;

import com.active.dao.GameUserHomeMapper;
import com.active.dao.LoginUsersMapper;
import com.active.model.GameUserHome;
import com.active.model.LoginUsers;
import com.active.service.IGameUserHomeService;
import com.active.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by chenqi on 2018/3/13.
 */
@Service
public class GameUserHomeService implements IGameUserHomeService {

    @Autowired
    private GameUserHomeMapper gameUserHomeMapper;

    @Override
    public void save(GameUserHome gameUserHome) {
        gameUserHomeMapper.save(gameUserHome);
    }

    @Override
    public List<GameUserHome> findByHomeId(Long homeId) {
        return gameUserHomeMapper.findByHomeId(homeId);
    }

    @Override
    public List<GameUserHome> findByUserId(Long userId) {
        return gameUserHomeMapper.findByUserId(userId);
    }
}
