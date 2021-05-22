package com.wlxy.hair.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlxy.hair.commen.HttpCode;
import com.wlxy.hair.commen.MyException;
import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.dao.THairDao;
import com.wlxy.hair.model.THair;
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
public class THairServiceImpl implements THairService {


	@Autowired
    THairDao tHairDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllTHair(PageParam<THair> pageParam){
        //对理发店信息进行分页
    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }
        List<THair> tHairList=tHairDao.getAllTHair(pageParam.getModel());
        PageInfo<THair> tHairPageInfo = new PageInfo<THair>(tHairList);

        return tHairPageInfo;

    }

	@CacheEvict(value = "tHairs",key = "#p0")
    @Override
    public boolean removeTHairById(int id){
    	return tHairDao.removeTHairById(id)==1;
    }

	@CachePut(value = "tHairs",key = "#p0.id")
    @Override
    public Object addTHair(THair tHair){
        tHairDao.addTHair(tHair);

        return tHairDao.getTHairById(tHair.getId());
    }

	@Override
    public boolean updateTHair(THair tHair){
    	if(StringUtils.isEmpty(tHair.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改t_hair时，id不能为空");
        }

        return tHairDao.updateTHair(tHair)==1;
    }

	@Cacheable(key = "#p0",value="tHairs")
    @Override
    @Transactional(readOnly = true)
    public THair getTHairById(int id){
    	return tHairDao.getTHairById(id);

    }

    @Override
    public THair getTHairByRealName(String realname) {
        return tHairDao.getTHairByRealName(realname);
    }

    @Override
    public Object getAllTHairRealName() {
        return tHairDao.getAllTHairRealName();
    }


}
