package com.imooc.sell.repositories;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDetailRepositoryTest  extends SellApplicationTests {

    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void save(){

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("300003");
        orderDetail.setOrderId("200002");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductId("100001");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductPrice(new BigDecimal(3.2));
        orderDetail.setProductQuantity(2);

        OrderDetail result = repository.save(orderDetail);
        assertNotNull(result);
    }


    //    List<OrderDetail> findByOrderId(String orderId);

    @Test
    public void findByOrderId(){
        List<OrderDetail> result = repository.findByOrderId("200001");
        assertNotEquals(0,result.size());
    }

}