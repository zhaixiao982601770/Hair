package com.wlxy.hair.service;


import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.model.TOrder;
import com.wlxy.hair.model.TOrderHead;


public interface TOrderService {

    public Object getAllTOrder(PageParam<TOrder> pageParam);

    public boolean removeTOrderById(int id);

    public Object addTOrder(TOrder tOrder);

    public boolean updateTOrder(TOrder tOrder);

    public TOrder getTOrderById(int id);

}
