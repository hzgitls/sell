package com.imooc.sell.repositories;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;
    @Test
//    @Trantsactional
    public void findByIdTest(){
        ProductCategory pc = repository.getOne(1);
        if (pc != null){
            System.out.println(pc.toString());

        }
        assertNotNull(pc);
    }


    @Test
    public void findByCategoryTypeIn(){
        List<Integer> categoryTypes = Arrays.asList(1,2,3,4);
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(categoryTypes);
        productCategoryList.forEach( v -> System.out.println(v.toString()));
        assertNotEquals(0,productCategoryList.size());
    }

    @Test
    @Transactional
    public void save(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(3);
        productCategory.setCategoryName("女生专爱");
        productCategory.setCategoryType(3);
        ProductCategory pc = repository.save(productCategory);
        assertNotNull(pc);
    }

    @Test
    @Transactional
    public void update(){
        ProductCategory productCategory = repository.getOne(1);
        productCategory.setCategoryName("热销榜");
        ProductCategory pc = repository.save(productCategory);
        assertNotNull(pc);
    }


    @Ignore
    @Test
    @Transactional
    public void delete(){
        repository.delete(1);
    }

}