package com.imooc.sell.controller;

import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.config.WechatMpConfig;
import com.imooc.sell.converter.OrderForm2OrderDTOConverter;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import com.imooc.sell.service.BuyerService;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 卖家端商品
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {


    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法...");
        log.info("code={}",code);
//        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxb5ab90f0c8d1189f&secret=8bdf6a68df39b47215200afd08d598cd&code="+code+"&grant_type=authorization_code\n";
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxb5ab90f0c8d1189f&secret=8bdf6a68df39b47215200afd08d598cd&code="+code+"&grant_type=authorization_code";
        log.info("url={}",url);
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        log.info("response={}",response);

    }

}
