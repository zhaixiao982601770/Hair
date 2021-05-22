package com.wlxy.hair.service;


import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.model.TOrderHead;


public interface TOrderHeadService {



	Object getAllTOrderHead(PageParam<TOrderHead> pageParam);

    boolean removeTOrderHeadById(int id);

    Object addTOrderHead(TOrderHead tOrderhead);

    boolean updateTOrderHead(TOrderHead tOrderhead);

    TOrderHead getTOrderHeadById(int id);




}
