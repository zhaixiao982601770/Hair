package com.wlxy.hair.controller;


import com.wlxy.hair.commen.MyRsp;
import com.wlxy.hair.model.TUser;
import com.wlxy.hair.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//注册
@RestController
@RequestMapping("reg")
@CrossOrigin //解决跨域问题
@Api(value = "注册接口模块",description = "这是用户注册接口文档")
public class RegController {

    @Autowired
    TUserService tUserService;

    @ApiOperation("用户注册")
    @PostMapping("/user")
    public Object user(@RequestBody @Valid TUser user){

        TUser  u =tUserService.register(user);

        return u!=null? MyRsp.success(u).msg("注册成功"):MyRsp.error().msg("注册失败");
    }

    @ApiOperation("判断用户名是否被占用")
    @PostMapping(value = "/userNameIsReged/{userName}")
    public Object userNameIsReged(@PathVariable("userName") String userName){

        TUser user=tUserService.userNameIsReged(userName);
        return user!=null?MyRsp.error().msg("该用户名已经被使用"):MyRsp.success(userName).msg("该用户名可以使用");

    }


}
