package com.wlxy.hair.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "TOrder" ,description = "")
@Data  // 自动生成get set 和构造器
public class TOrder implements Serializable {

	@ApiModelProperty(value = "" ,name = "id")
	private Integer id;
	// 预约用户id
	@ApiModelProperty(value = "预约用户id" ,name = "userId")
	private Integer userId;
	// 预约用户名字
	@ApiModelProperty(value = "预约用户名字" ,name = "userName")
	private String userName;
	// 理发店名字
	@ApiModelProperty(value = "理发店名字" ,name = "storeName")
	private String storeName;
	// 理发店照片
	@ApiModelProperty(value = "理发店照片" ,name = "storePic")
	private String storePic;
	// 订单状态
	@ApiModelProperty(value = "订单状态" ,name = "orderStatus")
	private Integer orderStatus;
	// 订单创建时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT-03:00")
	@ApiModelProperty(value = "订单创建时间" ,name = "createTime")
	private Date createTime;
	// 订单完成时间
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT-03:00")
	@ApiModelProperty(value = "订单完成时间" ,name = "orderTime")
	private Date orderTime;
	// 订单價格
	@ApiModelProperty(value = "订单價格" ,name = "price")
	private Integer price;
}
