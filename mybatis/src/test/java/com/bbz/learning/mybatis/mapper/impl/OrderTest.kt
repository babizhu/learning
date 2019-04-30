package com.bbz.learning.mybatis.mapper.impl

import com.bbz.learning.mybatis.dto.User
import com.bbz.learning.mybatis.dto.UserCondition
import com.bbz.learning.mybatis.mapper.OrderMapper
import com.bbz.learning.mybatis.mapper.UserMapper
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat


class OrderTest {

    private lateinit var orderMapper: OrderMapper

    @Before
    fun setUp() {
        val stream = Resources.getResourceAsStream("mybatis-config.xml")
        val factory = SqlSessionFactoryBuilder().build(stream)
        val sqlSession = factory.openSession()
//        orderMapper = UserMapperImpl(sqlSession)//最原始的方法

        orderMapper = sqlSession.getMapper(OrderMapper::class.java)//动态代理的办法，不用生成实现类
        /**
         * 开启动态代理之后需要注意：
         * 1、配置文件中到namespace必须为Mapper接口的全路径，例如：com.bbz.learning.mybatis.mapper.UserMapper
         * 2、id必须等于方法名
         * 3、resultType必须等于方法的返回值的类型
         * 4、parameterType必须等于方法的参数类型（不一定？）
         */

    }

    @Test
    fun queryOrderWithUserByOrderNumberFlat() {
        val userOrder = orderMapper.queryOrderWithUserByOrderNumberFlat("201807010001")
        println(userOrder)
    }

    @Test
    fun queryOrderWithUserByOrderNumber() {
        val userOrder = orderMapper.queryOrderWithUserByOrderNumber("201807010001")
        println(userOrder)
    }

}