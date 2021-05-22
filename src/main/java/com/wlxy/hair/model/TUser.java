package com.wlxy.hair.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "TUser" ,description = "")
@Data  // 自动生成get set 和构造器
public class TUser implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 登录名
    @ApiModelProperty(value = "登录名" ,name = "username")
	private String username;
	// 真实名字
    @ApiModelProperty(value = "真实名字" ,name = "realname")
	private String realname;
	// 登录密码
    @ApiModelProperty(value = "登录密码" ,name = "password")
	private String password;
	// 邮箱地址
    @ApiModelProperty(value = "邮箱地址" ,name = "email")
	private String email;
	// 电话号码
    @ApiModelProperty(value = "电话号码" ,name = "tel")
	private String tel;
	// 用户身份，0是管理员，1是普通用户，2是商家
    @ApiModelProperty(value = "用户身份，0是管理员，1是普通用户，2是商家" ,name = "gender")
	private Integer gender;
	// 用户状态
    @ApiModelProperty(value = "用户状态" ,name = "status")
	private Integer status;

}
