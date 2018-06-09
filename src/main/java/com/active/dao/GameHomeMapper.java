package com.active.dao;

import com.active.model.GameHome;
import com.active.model.LoginUsers;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chenqi on 2018/3/13.
 */
@Repository
public interface GameHomeMapper {
    void save(GameHome gameHome);
    GameHome findByPwd(String gamePwd);
    GameHome findByName(String name);
}
