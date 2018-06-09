package com.active.dao;

import com.active.model.GameConfig;
import org.springframework.stereotype.Repository;

/**
 * Created by chenqi on 2018/3/13.
 */
@Repository
public interface GameConfigMapper {
    void update(Long homeUserNum);
    Long findNum();
}
