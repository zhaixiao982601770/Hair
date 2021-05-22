package com.wlxy.hair.dao;

import com.wlxy.hair.model.THair;
import com.wlxy.hair.model.TOrder;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface TOrderDao {


    List<TOrder> getAllTOrder(TOrder tOrder);

    @Delete("delete from t_order where id = #{id}")
    int removeTOrderById(int id);

    int addTOrder(TOrder tOrder);

    int updateTOrder(TOrder tOrder);

    @Select("select * from t_order where id =#{id}")
    TOrder getTOrderById(int id);

    @Select("select * from t_order where tOrderName =#{tOrderName}")
    TOrder getTOrderByTOrderName(String tOrderName);

}
