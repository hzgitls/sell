package com.imooc.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.lisong.sellpro.enums.ProductStatusEnum;
//import com.lisong.sellpro.utils.EnumUtil;
import com.imooc.sell.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 */
@Entity
//@Table(name = "product_info2")
@Data
@DynamicUpdate
//@Proxy(lazy = false)
public class ProductInfo implements Serializable {


    private static final long serialVersionUID = -7539767355190593256L;
    /**商品id*/
    @Id
//    @Column(name = "id")
    private String productId;
    /**商品名字*/
    private String productName;
    /**单价*/
    private BigDecimal productPrice;
    /**库存*/
    private Integer productStock;
    /**描述*/
    private String productDescription;
    /**小图*/
    private String productIcon;
    /**状态 ,0正常1下架*/
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    /**类目编号*/
    private Integer categoryType;
    /**创建时间*/

//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_time")
    private Date createTime;// = new Date();
    /**更新*/
//    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;// = new Date();

//    @JsonIgnore
//    public ProductStatusEnum getProductStatusEnum(){
//        return EnumUtil.getByCode(productStatus,ProductStatusEnum.class);
//    }

}
