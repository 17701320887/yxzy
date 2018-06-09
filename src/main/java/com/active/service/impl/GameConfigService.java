package com.active.service.impl;

import com.active.dao.GameConfigMapper;
import com.active.model.GameConfig;
import com.active.service.IGameConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by chenqi on 2018/3/13.
 */
@Service
public class GameConfigService implements IGameConfigService{

    @Autowired
    private GameConfigMapper gameConfigMapper;

    @Override
    public void update(Long homeUserNum) {
        gameConfigMapper.update(homeUserNum);
    }

    @Override
    public Long findNum() {
        return gameConfigMapper.findNum();
    }
}
