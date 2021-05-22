package com.wlxy.hair.controller;

import com.wlxy.hair.commen.HttpCode;
import com.wlxy.hair.commen.MyException;
import com.wlxy.hair.commen.MyRsp;
import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.model.THair;
import com.wlxy.hair.model.TUser;
import com.wlxy.hair.service.THairService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@Api(value = "tHair模块接口",description = "这是一个模块的接口文档")
@RestController
@Slf4j
@CrossOrigin
public class THairController {

	@Autowired
    THairService tHairService;

	@ApiOperation("查询所有 支持多条件分页排序查询")
    @PostMapping("/getAllTHair")
    public Object getAllTHair(@RequestBody PageParam<THair> pageParam){
        return MyRsp.success(tHairService.getAllTHair(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeTHairById/{id}")
    public Object removeTHairByTHairName(@PathVariable("id") int id){

        return tHairService.removeTHairById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addTHair")
    public Object addTHair(@RequestBody @Valid THair tHairParam){
        THair tHair=(THair)tHairService.addTHair(tHairParam);
        return tHair!=null?MyRsp.success(tHair).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateTHair")
    public Object updateTHair(@RequestBody@Valid THair tHair){
        return tHairService.updateTHair(tHair)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getTHairById/{id}")
    public Object getTHairById(@PathVariable("id") int id){

        THair tHair=tHairService.getTHairById(id);
        return tHair!=null?MyRsp.success(tHair):MyRsp.wrapper(new MyException(HttpCode.ERROR));
    }

    //根据用户名进行查询
    @PostMapping("/getTHairByRealName/{realname}")
    public Object getTHairByRealName(@PathVariable("realname") String realname){

        THair tHair=tHairService.getTHairByRealName(realname);
        return tHair!=null?MyRsp.success(tHair):MyRsp.wrapper(new MyException(HttpCode.ERROR));
    }

    //获取所有用户真实名字
    @ApiOperation("查询所有用户的真实名字")
    @PostMapping("/getAllTHairName")
    public Object getAllTHairName(){
        return MyRsp.success(tHairService.getAllTHairRealName()).msg("查询成功");
    }

}
