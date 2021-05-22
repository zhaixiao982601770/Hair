package com.wlxy.hair.commen;


import com.wlxy.hair.model.TUser;
import com.wlxy.hair.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

//發送郵箱
@RestController
@RequestMapping("email")
@CrossOrigin //解决跨域问题
@Api(value = "郵箱模块",description = "这是發郵件的接口")
public class EmailController {

    @Autowired
    TUserService tUserService;

    @ApiOperation("發送郵件")
    @GetMapping("/sendPasswordToEmail/{email}")
    public Object user(@PathVariable("email") String email){

        TUser  u =tUserService.getTUserByEmail(email);

        if (u!=null){
            String mima=(new Random().nextInt(899999)+10000)+"mm";
            u.setPassword(mima);
            tUserService.updateTUser(u);

            try {
                EmailUtil.sendEmail(mima,email);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return MyRsp.success(null).msg("發送成功請注意查收郵件");
        }else {
            return MyRsp.error().msg("該郵箱不存在");
        }
        /*return u!=null? MyRsp.success(u).msg("發送成功"):MyRsp.error().msg("郵箱不存在");*/
    }
}
