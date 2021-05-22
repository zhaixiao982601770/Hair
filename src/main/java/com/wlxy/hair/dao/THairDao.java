package com.wlxy.hair.dao;

import com.wlxy.hair.model.THair;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface THairDao {


    List<THair> getAllTHair(THair tHair);

    @Delete("delete from t_hair where id = #{id}")
    int removeTHairById(int id);

    int addTHair(THair tHair);

    int updateTHair(THair tHair);

    @Select("select * from t_hair where id =#{id}")
    THair getTHairById(int id);

    @Select("select * from t_hair where tHairName =#{tHairName}")
    THair getTHairByTHairName(String tHairName);

    @Select("select * from t_hair where userName =#{realName}")
    THair getTHairByRealName(String realName);

    @Select("select username from t_hair")
    Object getAllTHairRealName();
}
