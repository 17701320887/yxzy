package com.active.service;

import com.active.model.GameConfig;

/**
 * Created by chenqi on 2018/3/13.
 */
public interface IGameConfigService {
    void update(Long homeUserNum);
    Long findNum();
}
