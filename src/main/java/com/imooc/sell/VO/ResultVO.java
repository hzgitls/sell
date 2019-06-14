package com.imooc.sell.VO;

import lombok.Data;

@Data
public class ResultVO<T> {

    /**状态码*/
    private Integer code;
    /**消息*/
    private String msg;
    /**数据*/
    private T date;
}
