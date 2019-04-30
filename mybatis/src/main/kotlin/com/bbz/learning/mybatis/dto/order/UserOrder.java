//import com.bbz.learning.mybatis.dto.User;
//
//import java.util.Date;

package com.bbz.learning.mybatis.dto.order;

import com.bbz.learning.mybatis.dto.User;

import java.util.Date;
//
public class UserOrder {
    private Integer orderId;
    private Long userId;
    private String orderNumber;
    private Date orderCreated;
    private Date orderUpdated;
    private User user;
}