package com.bbz.learning.mybatis.dto

import java.util.*

data class User(val id: Int?,
                val name: String,
                var age: Int,
                var password: String?,
                var birthday: Date,
                var sex: Int,
                var updated: Long=System.currentTimeMillis())