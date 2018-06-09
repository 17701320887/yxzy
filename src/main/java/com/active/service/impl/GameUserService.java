package com.active.service.impl;

import com.active.dao.GameUserMapper;
import com.active.model.GameUser;
import com.active.model.GameUserDto;
import com.active.service.IGameUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by chenqi on 2018/3/13.
 */
@Service
public class GameUserService implements IGameUserService{

    @Autowired
    private GameUserMapper gameUserMapper;

    @Override
    public void saveUser(GameUser gameUser) {
        gameUserMapper.save(gameUser);
    }

    @Override
    public List<GameUser> findByToken(String token) {
        return gameUserMapper.findByToken(token);
    }

    @Override
    public List<GameUserDto> findUserDay() {
        return gameUserMapper.findUserDay();
    }

    @Override
    public List<GameUserDto> findAllUser() {
        return gameUserMapper.findAllUser();
    }
}
