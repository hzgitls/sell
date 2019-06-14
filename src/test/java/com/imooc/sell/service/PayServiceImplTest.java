package com.imooc.sell.service;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
@Slf4j
public class PayServiceImplTest extends SellApplicationTests {

    @Autowired private PayService payService;

    @Autowired OrderService orderService;

    @Test
    public void create() {

        OrderDTO orderDTO =  orderService.findOne("1559790497055164190");
        payService.create(orderDTO);

    }

    @Test
    public void refund() {

        OrderDTO orderDTO =  orderService.findOne("1560497240357726388");
        payService.refund(orderDTO);

    }
}