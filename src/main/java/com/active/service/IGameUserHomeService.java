package com.active.service;

import com.active.dao.GameUserHomeMapper;
import com.active.model.GameUserHome;

import java.util.List;

/**
 * Created by chenqi on 2018/3/13.
 */
public interface IGameUserHomeService {
    void save(GameUserHome gameUserHome);
    List<GameUserHome> findByHomeId(Long homeId);
    List<GameUserHome> findByUserId(Long userId);
}
