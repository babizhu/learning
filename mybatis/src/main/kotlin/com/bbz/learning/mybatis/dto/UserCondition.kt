package com.bbz.learning.mybatis.dto

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy

/**
 * 查询条件
 */
data class UserCondition(
        val name: String? = null,
        val age: Int? = null,
        val sex: Boolean? = null
)
