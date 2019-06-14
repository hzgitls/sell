package com.imooc.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccoutConfig {

    /**公众账号ID*/
    private String mpAppId;

    /**开发者密码*/
    private String mpAppSecret;

    /**商户号*/
    private String mchId;

    /**商户秘钥*/
    private String mchKey;

    /**商户证书路径*/
    private String keyPath;

    /**微信支付异步通知地址*/
    private String notifyUrl;
}
