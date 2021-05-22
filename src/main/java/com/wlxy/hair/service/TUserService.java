package com.wlxy.hair.service;

import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.model.TUser;

import java.util.List;


public interface TUserService {



    Object getAllTUser(PageParam<TUser> pageParam);

    boolean removeTUserById(int id);

    Object addTUser(TUser tUser);

    boolean updateTUser(TUser tUser);

    TUser getTUserById(int id);

    /*,int grander*/
    TUser login(String username, String password,int gender);

    TUser register(TUser user);

    TUser userNameIsReged(String userName);

    TUser getTUserByEmail(String email);

    TUser getTUserByRealName(String realName);
}
