package com.bbz.learning.mybatis.dto

import java.util.*

/**
 * 属性的申明顺序必须和mapper.xml里面select 语句的顺序保持一致
 *  select
 *  user.id as id,
 *  user.name as name,
 *  user.name as secondName,
 *  user.age as age,
 *  user.password as password,
 *  user.birthday as birthday,
 *  user.sex as sex,
 *  user.updated
 *  from
 *  user
 *  where id = #{id};
 */
data class User(val id: Int? = null,
                var name: String? = null,
                var secondName: String = "",
                var age: Int? = null,
                var password: String? = null,
                var birthday: Date? = null,
                var sex: Int? = null,
                var updated: Long? = null
)