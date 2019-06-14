package com.imooc.sell.service;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.OrderStatusEnum;
import com.imooc.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@Slf4j
public class OrderServiceImplTest extends SellApplicationTests {

    private static final String BUYER_OPENID = "oOQ6T5z0SNB5Ruc9XyirKMo39t-U"; //ls
    private static final String BUYER_OPENID2 = "oOQ6T5-e2C-eYh6AnXEXBbGE6s3Y"; //lm
    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("ls");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerOpenid(BUYER_OPENID);
        orderDTO.setBuyerPhone("12345678900");

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("100005");
        o1.setProductQuantity(1);
        orderDetailList.add(o1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("[创建订单] result={}",result);
        assertNotNull(result);
    }

    @Test
    public void findOne() {

        OrderDTO result = orderService.findOne("1559348286556836678");
        assertNotNull(result);
    }

    @Test
    public void findList() {

        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList("900003",request);
        assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO result = orderService.findOne("1559348286556836678");
        OrderDTO orderDTO = orderService.cancel(result);
        assertNotNull(orderDTO);
    }

    @Ignore
    @Test
    @Transactional
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("200001");
        OrderDTO result = orderService.finish(orderDTO);
        assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }
    @Ignore
    @Test
    @Transactional
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("200001");
        OrderDTO result = orderService.paid(orderDTO);
        assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }
}