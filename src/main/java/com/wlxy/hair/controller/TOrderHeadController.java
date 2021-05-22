package com.wlxy.hair.controller;

import com.wlxy.hair.commen.HttpCode;
import com.wlxy.hair.commen.MyException;
import com.wlxy.hair.commen.MyRsp;
import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.model.TOrderHead;
import com.wlxy.hair.service.TOrderHeadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Api(value = "tOrderHead模块接口",description = "这是一个订单头显示的接口文档")
@RestController
@Slf4j
@CrossOrigin
public class TOrderHeadController {

	@Autowired
    TOrderHeadService tOrderHeadService;

	@ApiOperation("查询所有 支持多条件分页排序查询")
    @PostMapping("/getAllTOrderHead")
    public Object getAllTOrderHead(@RequestBody PageParam<TOrderHead> pageParam){
        return MyRsp.success(tOrderHeadService.getAllTOrderHead(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeTOrderHeadById/{id}")
    public Object removeTOrderHeadByTOrderHeadName(@PathVariable("id") int id){

        return tOrderHeadService.removeTOrderHeadById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addTOrderHead")
    public Object addTOrderHead(@RequestBody @Valid TOrderHead tOrderHeadParam){
        TOrderHead tOrderHead=(TOrderHead)tOrderHeadService.addTOrderHead(tOrderHeadParam);

        return tOrderHead!=null?MyRsp.success(tOrderHead).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateTOrderHead")
    public Object updateTOrderHead(@RequestBody@Valid TOrderHead tOrderHead){
        return tOrderHeadService.updateTOrderHead(tOrderHead)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getTOrderHeadById/{id}")
    public Object getTOrderHeadById(@PathVariable("id") int id){

        TOrderHead tOrderHead=tOrderHeadService.getTOrderHeadById(id);
        return tOrderHead!=null?MyRsp.success(tOrderHead):MyRsp.wrapper(new MyException(HttpCode.ERROR));
    }

}
