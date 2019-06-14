package com.imooc.sell.repositories;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired private ProductRepository repository;

    @Test
    public void getOne(){
        ProductInfo pc = repository.getOne("100001");
        if (pc != null){
            System.out.println(pc.toString());

        }
        assertNotNull(pc);
    }
    @Test
    public void findByProductStatus(){
        List<ProductInfo> result = repository.findByProductStatus(0);
        assertNotEquals(0,result.size());
    }

    @Test
    @Transactional
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("100003");
        productInfo.setProductName("冰红茶");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("味道很美");
        productInfo.setProductIcon("http://xxx.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo pc = repository.save(productInfo);
        assertNotNull(pc);
    }

//    @Ignore
    @Test
    @Transactional
    public void update(){
        ProductInfo productInfo = repository.getOne("1");
        productInfo.setProductName("yy333");
        ProductInfo pc = repository.save(productInfo);
        assertNotNull(pc);
    }


    @Ignore
    @Test
    @Transactional
    public void delete(){
        repository.delete("1");
    }

}