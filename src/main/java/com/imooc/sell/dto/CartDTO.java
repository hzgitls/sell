package com.imooc.sell.dto;

import lombok.Data;

/**
 * 购物车
 */
@Data
public class CartDTO {

    /**商品id*/
    private String productId;

    /**数量*/
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
