package com.active.dao;

import com.active.model.GameUser;
import com.active.model.GameUserDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenqi on 2018/3/13.
 */
@Repository
public interface GameUserMapper {
    void save(GameUser gameUser);
    List<GameUser> findByToken(String token);
    List<GameUserDto> findUserDay();
    List<GameUserDto> findAllUser();
}
