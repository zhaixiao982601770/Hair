package com.wlxy.hair.dao;

import com.wlxy.hair.model.TUser;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TUserDao {


    List<TUser> getAllTUser(TUser tUser);

    @Delete("delete from t_user where id = #{id}")
    int removeTUserById(int id);

    int addTUser(TUser tUser);

    int updateTUser(TUser tUser);

    @Select("select * from t_user where id =#{id}")
    TUser getTUserById(int id);

    @Select("select * from t_user where username =#{username}")
    TUser getTUserByTUserName(String tUserName);

    @Select("select * from t_user where email =#{email}")
    TUser getTUserByEmail(String email);

    @Select("select * from t_user where realname =#{realname}")
    TUser getTUserByRealName(String realName);
}
