package com.wlxy.hair.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "TOrderHead" ,description = "")
@Data  // 自动生成get set 和构造器
public class TOrderHead implements Serializable {
	// 主键
    @ApiModelProperty(value = "主键" ,name = "id")
	private Integer id;
	// 订单用户id
    @ApiModelProperty(value = "订单用户id" ,name = "userid")
	private Integer userId;
	// 订单总件数
    @ApiModelProperty(value = "订单总件数" ,name = "ordertotal")
	private String userName;
	// 店名
    @ApiModelProperty(value = "店名" ,name = "storename")
	private String storeName;
	// 理发店照片
    @ApiModelProperty(value = "理发店照片" ,name = "storepic")
	private String storePic;
	// 理发店地址
    @ApiModelProperty(value = "理发店地址" ,name = "address")
	private String address;
	// 理发类型
    @ApiModelProperty(value = "理发类型" ,name = "type")
	private String type;
	// 理发价格
    @ApiModelProperty(value = "理发价格" ,name = "price")
	private Integer price;
	// 预约状态
    @ApiModelProperty(value = "预约状态" ,name = "orderstatus")
	private Integer orderStatus;
	// 预约時間
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT-03:00")
	@ApiModelProperty(value = "预约時間" ,name = "createTime")
	private Date createTime;


}
