package com.active.service;

import com.active.model.GameUser;
import com.active.model.GameUserDto;

import java.util.List;

/**
 * Created by chenqi on 2018/3/13.
 */
public interface IGameUserService {
    void saveUser(GameUser gameUser);
    List<GameUser> findByToken(String token);
    List<GameUserDto> findUserDay();
    List<GameUserDto> findAllUser();
}
