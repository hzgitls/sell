package com.imooc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest2 {

//    private final Logger logger = LoggerFactory.getLogger(LoggerTest2.class);

    @Test
    public void test1(){

//        ERROR(40, "ERROR"),
//        WARN(30, "WARN"),
//        INFO(20, "INFO"),
//        DEBUG(10, "DEBUG"),
//        TRACE(0, "TRACE");
        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
        String name = "imooc";
        String pwd = "imooc123456";
        log.info("name:{},pwd:{}",name,pwd);
    }

}
