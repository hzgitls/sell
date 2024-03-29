package com.imooc.sell.form;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductForm {
    /**商品id*/
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
//    /**状态 ,0正常1下架*/
//    private Integer productStatus;
    /**类目编号*/
    private Integer categoryType;


}
