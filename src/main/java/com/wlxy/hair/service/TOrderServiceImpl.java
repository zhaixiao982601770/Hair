package com.wlxy.hair.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlxy.hair.commen.HttpCode;
import com.wlxy.hair.commen.MyException;
import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.dao.TOrderDao;
import com.wlxy.hair.model.TOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;


@Slf4j
@Service
@Transactional
public class TOrderServiceImpl implements TOrderService {


    @Autowired
    TOrderDao tOrderDao;

    @Override
    @Transactional(readOnly = true)
    public Object getAllTOrder(PageParam<TOrder> pageParam){

        PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }

        List<TOrder> tOrderList=tOrderDao.getAllTOrder(pageParam.getModel());
        PageInfo<TOrder> tOrderPageInfo = new PageInfo<TOrder>(tOrderList);

        return tOrderPageInfo;

    }

    @Override
    public boolean removeTOrderById(int id){
        return tOrderDao.removeTOrderById(id)==1;
    }

    @Override
    public Object addTOrder(TOrder tOrder){
        tOrderDao.addTOrder(tOrder);

        return tOrderDao.getTOrderById(tOrder.getId());
    }

    @Override
    public boolean updateTOrder(TOrder tOrder){
        if(StringUtils.isEmpty(tOrder.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改t_order时，id不能为空");
        }

        return tOrderDao.updateTOrder(tOrder)==1;
    }

    @Override
    @Transactional(readOnly = true)
    public TOrder getTOrderById(int id){
        return tOrderDao.getTOrderById(id);
    }

}
