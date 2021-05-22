package com.wlxy.hair.controller;

import com.wlxy.hair.commen.HttpCode;
import com.wlxy.hair.commen.MyException;
import com.wlxy.hair.commen.MyRsp;
import com.wlxy.hair.commen.PageParam;
import com.wlxy.hair.model.TOrder;
import com.wlxy.hair.service.TOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "tOrder模块接口",description = "这是一个订单完成的接口文档")
@RestController
@Slf4j
@CrossOrigin
public class TOrderController {

    @Autowired
    TOrderService tOrderService;

    @ApiOperation("查询所有支持多条件分页排序查询")
    @PostMapping("/getAllTOrder")
    public Object getAllTOrder(@RequestBody PageParam<TOrder> pageParam){
        return MyRsp.success(tOrderService.getAllTOrder(pageParam)).msg("查询成功");
    }

    @GetMapping("/removeTOrderById/{id}")
    public Object removeTOrderByTOrderName(@PathVariable("id") int id){

        return tOrderService.removeTOrderById(id)?MyRsp.success(null).msg("删除成功"):MyRsp.error().msg("删除失败");
    }

    @PostMapping("/addTOrder")
    public Object addTOrder(@RequestBody @Valid TOrder tOrderParam){
        TOrder tOrder=(TOrder)tOrderService.addTOrder(tOrderParam);

        return tOrder!=null?MyRsp.success(tOrder).
                msg("添加成功"):MyRsp.error().msg("添加失败");
    }


    @PutMapping("/updateTOrder")
    public Object updateTOrder(@RequestBody@Valid TOrder tOrder){
        return tOrderService.updateTOrder(tOrder)?MyRsp.success(null)
                .msg("修改成功"):MyRsp.error().msg("修改失败");
    }

    @GetMapping("/getTOrderById/{id}")
    public Object getTOrderById(@PathVariable("id") int id){
        TOrder tOrder=tOrderService.getTOrderById(id);
        return tOrder!=null?MyRsp.success(tOrder):MyRsp.wrapper(new MyException(HttpCode.ERROR));
    }

}
