package com.wlxy.hair.service;


import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.model.THair;

import java.util.List;

public interface THairService {



	Object getAllTHair(PageParam<THair> pageParam);

    boolean removeTHairById(int id);

    Object addTHair(THair tHair);

    boolean updateTHair(THair tHair);

    THair getTHairById(int id);


    THair getTHairByRealName(String realname);

    Object getAllTHairRealName();
}
