package com.wlxy.hair.dao;

import com.wlxy.hair.model.TOrderHead;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface TOrderHeadDao {


    List<TOrderHead> getAllTOrderHead(TOrderHead tOrderHead);

    @Delete("delete from t_orderhead where id = #{id}")
    int removeTOrderHeadById(int id);


    int addTOrderHead(TOrderHead tOrderhead);

    int updateTOrderHead(TOrderHead tOrderhead);

    @Select("select * from t_orderhead where id =#{id}")
    TOrderHead getTOrderHeadById(int id);

    @Select("select * from t_orderhead where tOrderheadName =#{tOrderheadName}")
    TOrderHead getTOrderHeadByTOrderHeadName(String tOrderHeadName);




}
