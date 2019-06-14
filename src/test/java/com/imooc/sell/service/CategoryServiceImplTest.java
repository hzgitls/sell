package com.imooc.sell.service;

import com.imooc.sell.SellApplication;
import com.imooc.sell.SellApplicationTests;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryServiceImplTest extends SellApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findOne() {
        ProductCategory result = categoryService.findOne(2);
        assertNotNull(result);

    }

    @Test
    public void findAll() {
        List<ProductCategory>  result = categoryService.findAll();
        assertNotEquals(0,result.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory>  result = categoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));
        assertNotEquals(0,result.size());
    }

    @Test
    @Transactional
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(2);
        productCategory.setCategoryName("饮料");
        productCategory.setCategoryType(2);
        ProductCategory result = categoryService.save(productCategory);
        assertNotNull(result);
    }
}