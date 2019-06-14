package com.imooc.sell.repositories;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.OrderMaster;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderMasterRepositoryTest extends SellApplicationTests {

    @Autowired
    private OrderMasterRepository repository;

    private final String ORENID = "900002";
    @Test
    public void save(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("200003");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("13734321234");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid(ORENID);
        orderMaster.setOrderAmount(new BigDecimal(3.2));
        OrderMaster result = repository.save(orderMaster);
        assertNotNull(result);
    }
//    Page<OrderMaster> findByBuyerOpenid();
    @Test
    public void findByBuyerOpenid(){

        PageRequest request = new PageRequest(0,2);
        Page<OrderMaster> orderMasterPage = repository.findByBuyerOpenid(ORENID,request);
        assertNotEquals(0,orderMasterPage.getTotalElements());

    }

}