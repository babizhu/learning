package com.bbz.learning.mybatis.mapper

import com.bbz.learning.mybatis.dto.order.FlatUserOrder
import com.bbz.learning.mybatis.dto.order.UserOrder
import org.apache.ibatis.annotations.Param



interface OrderMapper{
    /**
     * 根据订单号查询订单用户的信息
     * @param orderNo
     * @return
     */
    fun queryOrderWithUserByOrderNumber(orderNo: String): UserOrder
    fun queryOrderWithUserByOrderNumberFlat(orderNo: String): FlatUserOrder
}