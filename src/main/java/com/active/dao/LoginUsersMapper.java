package com.active.dao;

import com.active.model.LoginUsers;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by chenqi on 2018/3/13.
 */
@Repository
public interface LoginUsersMapper {

    void save(LoginUsers users);

    void update(LoginUsers users);

    LoginUsers findUserByMP(@Param("mobile") String mobile,@Param("password") String password);

}
