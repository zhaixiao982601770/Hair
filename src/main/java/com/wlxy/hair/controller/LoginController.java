package com.wlxy.hair.controller;


import com.wlxy.hair.commen.MyRsp;
import com.wlxy.hair.model.TUser;
import com.wlxy.hair.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
@CrossOrigin//解决前后端跨域问题
public class LoginController {

    @Autowired
    TUserService tUserService;

    @PostMapping("/user")
    public Object user(@RequestBody TUser user){
/*,user.getGender()*/
        TUser  u =tUserService.login(user.getUsername(),user.getPassword(),user.getGender());

        return u!=null? MyRsp.success(u):MyRsp.error().msg("登录失败");
    }

}
