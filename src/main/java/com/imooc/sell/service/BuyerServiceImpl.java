package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderid) {
       return checkOrderOwner(openid, orderid);
    }

    @Override
    public OrderDTO cancel(String openid, String orderid) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderid);
        if (orderDTO == null){
            log.error("[取消订单] 查询不到该订单,orderid={}",orderid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderDTO;
    }

    private OrderDTO checkOrderOwner(String openid, String orderid) {
        OrderDTO orderDTO = orderService.findOne(orderid);

        if (orderDTO == null){
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("[查询订单] 订单的openid不一致,openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
