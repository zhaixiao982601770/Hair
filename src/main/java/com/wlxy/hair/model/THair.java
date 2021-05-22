package com.wlxy.hair.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


@ApiModel(value = "THair" ,description = "理发店信息")
@Data  // 自动生成get set 和构造器
public class THair implements Serializable {
	// 主键id
    @ApiModelProperty(value = "主键id" ,name = "id")
	private Integer id;
	// 理发店名字
    @ApiModelProperty(value = "理发店名字" ,name = "storeName")
	private String storeName;
	// 照片
    @ApiModelProperty(value = "照片" ,name = "storePic")
	private String storePic;
	// 理发店地址
    @ApiModelProperty(value = "理发店地址" ,name = "address")
	private String address;
	// 店铺介绍
    @ApiModelProperty(value = "店铺介绍" ,name = "storeDescribe")
	private String storeDescribe;
	// 店铺创建人
    @ApiModelProperty(value = "店铺创建人" ,name = "userName")
	private String userName;
	// 理发店状态
    @ApiModelProperty(value = "理发店状态" ,name = "storeStatus")
	private Integer storeStatus;
	// 浏览量
    @ApiModelProperty(value = "浏览量" ,name = "browse")
	private String browse;

    @ApiModelProperty(value = "实际价格" ,name = "oldPrice")
	private Integer oldPrice;

	@ApiModelProperty(value = "优惠价格" ,name = "newPrice")
	private Integer newPrice;

	@ApiModelProperty(value = "理发店电话" ,name = "tel")
	private String tel;
}
