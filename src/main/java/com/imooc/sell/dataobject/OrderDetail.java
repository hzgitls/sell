package com.imooc.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情表
 */
@Entity
@Data
//@DynamicUpdate
public class OrderDetail {

    /**订单详情id*/
    @Id
    private String detailId;
    /**订单id*/
    private String orderId;
    /**商品id*/
    private String productId;
    /**商品名称*/
    private String productName;
    /**价格*/
    private BigDecimal productPrice;
    /**数量*/
    private Integer productQuantity;
    /**商品小图*/
    private String productIcon;
    /**创建时间*/
//    private Date createTime;
    /**更新时间*/
//    private Date updateTime;

}
