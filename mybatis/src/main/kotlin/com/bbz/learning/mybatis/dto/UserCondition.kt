package com.bbz.learning.mybatis.dto

/**
 * 查询条件
 */
data class UserCondition(
        val name: String? = null,
        val age: Int? = null,
        val sex: Boolean? = null
)