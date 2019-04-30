package com.bbz.learning.mybatis.dto

import java.util.*

data class LoginRecord(
        val id: Int?,
        val userName: String,
        val loginDate: Date,
        val loginResult: Boolean
)