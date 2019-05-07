package com.bbz.learning.mybatis.mapper.impl

import com.bbz.learning.mybatis.mapper.LoginRecordMapper
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.Before
import org.junit.Test


class LoginRecordMapperTest {

    private lateinit var loginRecordMapper: LoginRecordMapper

    @Before
    fun setUp() {
        val stream = Resources.getResourceAsStream("mybatis-config.xml")
        val factory = SqlSessionFactoryBuilder().build(stream)
        val sqlSession = factory.openSession()
//        loginRecordMapper = loginRecordMapperImpl(sqlSession)//最原始的方法

        loginRecordMapper = sqlSession.getMapper(LoginRecordMapper::class.java)//动态代理的办法，不用生成实现类
        /**
         * 开启动态代理之后需要注意：
         * 1、配置文件中到namespace必须为Mapper接口的全路径，例如：com.bbz.learning.mybatis.mapper.loginRecordMapper
         * 2、id必须等于方法名
         * 3、resultType必须等于方法的返回值的类型
         * 4、parameterType必须等于方法的参数类型（不一定？）
         */

    }

    @Test
    fun queryById() {
        println(this.loginRecordMapper.queryById(1))
    }
//
    @Test
    fun queryAll() {
    loginRecordMapper.foo()

    println(loginRecordMapper.queryAll())
    }

    @Test
    fun queryAllMap() {
        val allMap = loginRecordMapper.queryAllMap()

        println("value的类型为${(allMap[1] ?: error(""))::class.java.name}")
        println(allMap[2])
    }
}