package com.imooc.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;

import com.imooc.sell.utils.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {

    /**类目id*/
    private String orderId;
    /**买家名字*/
    private String buyerName;
    /**买家电话*/
    private String buyerPhone;
    /**买家地址*/
    private String buyerAddress;
    /**买家微信openid*/
    private String buyerOpenid;
    /**订单总金额*/
    private BigDecimal orderAmount;
    /**订单状态，默认0新下单1完结2取消*/
    private Integer orderStatus;
    /**支付状态，默认0未支付*/
    private Integer payStatus;
    /**创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetailList;

//    @JsonIgnore
//    public OrderStatusEnum getOrderStatusEnum(){
////        return OrderStatusEnum.getOrderStatusEnum(orderStatus);
//        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
//    }

//    @JsonIgnore
//    public PayStatusEnum getPayStatusEnum(){
////        return PayStatusEnum.getPayStatusEnum(payStatus);
//        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
//    }




}
