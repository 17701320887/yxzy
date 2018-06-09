package com.active.service.impl;

import com.active.dao.LoginUsersMapper;
import com.active.model.LoginUsers;
import com.active.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by chenqi on 2018/3/13.
 */
@Service
public class LoginService implements ILoginService{

    @Autowired
    private LoginUsersMapper usersMapper;

    @Override
    public LoginUsers findUser(String mobile,String password) {
        LoginUsers user = usersMapper.findUserByMP(mobile,password);
        return user;
    }

    @Override
    public void saveUser(LoginUsers user) {
        usersMapper.save(user);
    }

    @Override
    public void updateLogin(LoginUsers user) {
        usersMapper.update(user);
    }
}
