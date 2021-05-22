package com.wlxy.hair.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlxy.hair.commen.HttpCode;
import com.wlxy.hair.commen.MyException;
import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.dao.TOrderHeadDao;
import com.wlxy.hair.model.TOrderHead;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;


@Slf4j
@Service
@Transactional
public class TOrderHeadServiceImpl implements TOrderHeadService {


	@Autowired
    TOrderHeadDao tOrderHeadDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllTOrderHead(PageParam<TOrderHead> pageParam){

    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<TOrderHead> tOrderHeadList=tOrderHeadDao.getAllTOrderHead(pageParam.getModel());
        PageInfo<TOrderHead> tOrderHeadPageInfo = new PageInfo<TOrderHead>(tOrderHeadList);

        return tOrderHeadPageInfo;

    }

	@CacheEvict(value = "tOrderHeads",key = "#p0")
    @Override
    public boolean removeTOrderHeadById(int id){
    	return tOrderHeadDao.removeTOrderHeadById(id)==1;
    }

	@CachePut(value = "tOrderHeads",key = "#p0.id")
    @Override
    public Object addTOrderHead(TOrderHead tOrderHead){
        tOrderHeadDao.addTOrderHead(tOrderHead);

        return tOrderHeadDao.getTOrderHeadById(tOrderHead.getId());
    }

	@Override
    public boolean updateTOrderHead(TOrderHead tOrderHead){
    	if(StringUtils.isEmpty(tOrderHead.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改t_orderhead时，id不能为空");
        }

        return tOrderHeadDao.updateTOrderHead(tOrderHead)==1;
    }

	@Cacheable(key = "#p0",value="tOrderheads")
    @Override
    @Transactional(readOnly = true)
    public TOrderHead getTOrderHeadById(int id){
    	return tOrderHeadDao.getTOrderHeadById(id);

    }




}
