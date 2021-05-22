package com.wlxy.hair.controller;

import com.wlxy.hair.commen.HttpCode;
import com.wlxy.hair.commen.MyException;
import com.wlxy.hair.commen.MyRsp;
import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.model.TUser;
import com.wlxy.hair.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "tUser模块接口",description = "这是一个用户的接口文档")
@RestController
@Slf4j
@CrossOrigin
public class TUserController {

	@Autowired
    TUserService tUserService;

	@ApiOperation("查询所有 支持多条件分页排序查询")
    @PostMapping("/getAllTUser")
    public Object getAllTUser(@RequestBody PageParam<TUser> pageParam){
        return MyRsp.success(tUserService.getAllTUser(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeTUserById/{id}")
    public Object removeTUserByTUserName(@PathVariable("id") int id){

        return tUserService.removeTUserById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addTUser")
    public Object addTUser(@RequestBody  @Valid TUser tUserParam){
        TUser tUser=(TUser)tUserService.addTUser(tUserParam);

        return tUser!=null?MyRsp.success(tUser).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }

    //修改用户信息
    @PutMapping("/updateTUser")
    public Object updateTUser(@RequestBody @Valid TUser tUser){
        return tUserService.updateTUser(tUser)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }


    //根据id进行查询
    @GetMapping("/getTUserById/{id}")
    public Object getTUserById(@PathVariable("id") int id){

        TUser tUser=tUserService.getTUserById(id);
        return tUser!=null?MyRsp.success(tUser):MyRsp.wrapper(new MyException(HttpCode.ERROR));
    }

    //根据用户名进行查询
    @PostMapping("/getTUserByName/{username}")
    public Object getTUserByName(@PathVariable("username") String username){

	    TUser user=tUserService.userNameIsReged(username);
	    return user!=null?MyRsp.success(user):MyRsp.wrapper(new MyException(HttpCode.ERROR));
    }

    //根据用户真实名字查询用户信息
    @ApiOperation("根据真实名字查询用户的信息")
    @PostMapping("/getTUserByRealName/{realname}")
    public Object getTUserByRealName(@PathVariable("realname") String realname){
        return MyRsp.success(tUserService.getTUserByRealName(realname)).msg("查询成功");
    }
}
