package com.imooc.sell.controller;

import com.imooc.sell.config.WechatMpConfig;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;

/**
 * 卖家端商品
 * 微信授权
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    @Qualifier("wxMpService")
    private WxMpService wxMpService;


    @Autowired
    private WechatMpConfig wechatMpConfig;

    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnUrl) {
        //1.配置
        //2.调用方法
//        String url = "http://exp.mynatapp.cc/sell/wechat/userInfo";
        String url = "http://p582pc.natappfree.cc/sell/wechat/userInfo";
//        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url,WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl));
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url,WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnUrl));
//        log.info("[微信网页授权] 获取code,redirectUrl={}",redirectUrl);
        return "redirect:" + redirectUrl;

    }

    @GetMapping("/userInfo")
    public String userinfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl) {

        log.info("[微信网页授权] 获取code,returnUrl,code={},returnUrl={}",code,returnUrl);
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);

            log.info("[微信网页授权] 获取accessToken,accessToken={},wxMpOAuth2AccessToken={}",wxMpOAuth2AccessToken.getAccessToken(),wxMpOAuth2AccessToken);

        } catch (WxErrorException e) {
            log.info("[微信网页授权] {}",e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),ResultEnum.WECHAT_MP_ERROR.getMessage());
        }
        String openid = wxMpOAuth2AccessToken.getOpenId();

        return "redirect:" + returnUrl + "?openid=" + openid;
    }

}
