package com.bbz.learning.mybatis.dto.order

import java.util.*

/**
 * 最简单的做法，申明一个包含Order字段和User字段的类
 */
data class FlatUserOrder(val orderId: Int,
                         val userId: Long,
                         val orderNumber: String,
                         val created: Date,
                         val updated: Date,
                         val name: String,
                         val age: Int,
                         val sex: Boolean
)