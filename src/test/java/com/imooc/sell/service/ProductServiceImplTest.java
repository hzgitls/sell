package com.imooc.sell.service;

import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class ProductServiceImplTest extends SellApplicationTests {

    @Autowired private ProductService productService;
    @Test
    public void findOne() {
        ProductInfo result = productService.findOne("100001");
//        assertNotNull(result);
        assertEquals("100001",result.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();
        assertNotEquals(0,result.size());

    }

    @Test
    public void findAll() {

        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    @Transactional
    public void save() {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("100001");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("味道很美");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo pc = productService.save(productInfo);
        assertNotNull(pc);
    }
}