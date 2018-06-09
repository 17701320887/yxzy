package com.active.dao;

import com.active.model.GameUserHome;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenqi on 2018/3/13.
 */
@Repository
public interface GameUserHomeMapper {
    void save(GameUserHome gameUserHome);
    List<GameUserHome> findByHomeId(Long homeId);
    List<GameUserHome> findByUserId(Long userId);
}
