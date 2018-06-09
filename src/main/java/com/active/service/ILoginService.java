package com.active.service;

import com.active.model.LoginUsers;

/**
 * Created by chenqi on 2018/3/13.
 */
public interface ILoginService{

//    void login(Users user);

    /**
     * 检查用户密码是否正确
     * @param mobile 登录手机号
     * @param password 登录密码
     * @return
     */
    LoginUsers findUser(String mobile,String password);

    void saveUser(LoginUsers user);

    void updateLogin(LoginUsers user);
}
