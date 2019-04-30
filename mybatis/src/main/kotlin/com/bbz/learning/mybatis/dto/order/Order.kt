package com.bbz.learning.mybatis.dto.order

import java.util.*

data class Order(val orderId: Int,
                 val userId: Long,
                 val orderNumber: String,
                 val created: Date,
                 val updated: Date)