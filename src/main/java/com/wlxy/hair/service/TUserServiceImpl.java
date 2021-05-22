package com.wlxy.hair.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wlxy.hair.commen.HttpCode;
import com.wlxy.hair.commen.MyException;
import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.dao.TUserDao;
import com.wlxy.hair.model.TUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
;import java.util.List;

@Slf4j
@Service
@Transactional
public class TUserServiceImpl implements TUserService {


	@Autowired
    TUserDao tUserDao;

	@Override
    @Transactional(readOnly = true)
	public Object getAllTUser(PageParam<TUser> pageParam){

    	PageHelper.startPage(pageParam.getPageNum(),pageParam.getPageSize());
        for(int i=0;i<pageParam.getOrderParams().length;i++){
            PageHelper.orderBy(pageParam.getOrderParams()[i]);
        }


        List<TUser> tUserList=tUserDao.getAllTUser(pageParam.getModel());
        PageInfo<TUser> tUserPageInfo = new PageInfo<TUser>(tUserList);

        return tUserPageInfo;

    }

	@CacheEvict(value = "tUsers",key = "#p0")
    @Override
    public boolean removeTUserById(int id){
    	return tUserDao.removeTUserById(id)==1;
    }

	@CachePut(value = "tUsers",key = "#p0.id")
    @Override
    public Object addTUser(TUser tUser){
        tUserDao.addTUser(tUser);

        return tUserDao.getTUserById(tUser.getId());
    }

	@Override
    public boolean updateTUser(TUser tUser){
    	if(StringUtils.isEmpty(tUser.getId())){
            throw new MyException(HttpCode.ERROR).msg("通过id修改t_user时，id不能为空");
        }

        return tUserDao.updateTUser(tUser)==1;
    }

	@Cacheable(key = "#p0",value="tUsers")
    @Override
    @Transactional(readOnly = true)
    public TUser getTUserById(int id){
    	return tUserDao.getTUserById(id);

    }


    //用户登录
    @Override
    public TUser login(String username, String password,int gender) {
        //存值
	    TUser tUser=new TUser();
        tUser.setUsername(username);
        tUser.setPassword(password);
        tUser.setGender(gender);

        //根据用户名密码查询用户
        List<TUser> tUsers=tUserDao.getAllTUser(tUser);
        TUser tUser1=null;
        if (tUsers.size()!=0){
            tUser1=tUsers.get(0);
        }

        return tUser1;
    }

    //用户注册
    @Override
    public TUser register(TUser user) {
        tUserDao.addTUser(user);

	    return tUserDao.getTUserById(user.getId());
    }

    @Override
    public TUser userNameIsReged(String userName) {
        return tUserDao.getTUserByTUserName(userName);
    }

    @Override
    public TUser getTUserByEmail(String email) {
        return tUserDao.getTUserByEmail(email);
    }

    @Override
    public TUser getTUserByRealName(String realName) {
        return tUserDao.getTUserByRealName(realName);
    }


}
