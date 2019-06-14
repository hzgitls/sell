package com.imooc.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.lisong.sellpro.enums.ProductStatusEnum;
//import com.lisong.sellpro.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 *
 */
@Entity
@Data
@DynamicUpdate
//@EntityListeners(AuditingEntityListener.class)
public class SellerInfo {

    /**id*/
    @Id
    private String sellerId;
    /**用户名字*/
    private String username;
    /**密码*/
    private String password;
    /**openid*/
    private String openid;
    /**创建时间*/
//    @CreatedDate
//    private String createTime;
    /**更新*/
//    @LastModifiedDate
//    private String updateTime;

}
