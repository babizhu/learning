package com.bbz.learning.mybatis.mapper.impl

import com.bbz.learning.mybatis.dto.User
import com.bbz.learning.mybatis.dto.UserCondition
import com.bbz.learning.mybatis.mapper.UserMapper
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSession
import org.apache.ibatis.session.SqlSessionFactoryBuilder
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*


class UserMapperImplTest {

    private lateinit var userMapper: UserMapper
    private lateinit var sqlSession: SqlSession

    @Before
    fun setUp() {
        val stream = Resources.getResourceAsStream("mybatis-config.xml")
        val factory = SqlSessionFactoryBuilder().build(stream)
        sqlSession = factory.openSession()
//        userMapper = UserMapperImpl(sqlSession)//最原始的方法

        userMapper = sqlSession.getMapper(UserMapper::class.java)//动态代理的办法，不用生成实现类
        /**
         * 开启动态代理之后需要注意：
         * 1、配置文件中到namespace必须为Mapper接口的全路径，例如：com.bbz.learning.mybatis.mapper.UserMapper
         * 2、id必须等于方法名
         * 3、resultType必须等于方法的返回值的类型
         * 4、parameterType必须等于方法的参数类型（不一定？）
         */

    }

    @Test
    fun queryUserById() {

        System.out.println(this.userMapper.queryUserById(1))
    }

    @Test
    fun queryUserAll() {
        println(userMapper.queryUserAll())
    }

    @Test
    fun queryUserAllMap() {
        println(this.userMapper.queryUserAllMap())
    }

    @Test
    fun insertUser() {
        val user = User(id = null,
                age =Random().nextInt(100), birthday = SimpleDateFormat("yyyy/MM/dd").parse("1990/09/02"),
                name = "xy",
                sex = 1,
                updated = System.currentTimeMillis()
        )
        println(user)
        println("===============插入后，注意看id属性已经赋值===============")
        userMapper.insertUser(user)
//        this.sqlSession.commit()
        println(user)

        user.id?.let {
            println("user is ${userMapper.queryUserById(it)}")
        }

//        sqlSession.close()




    }

    @Test
    fun updateUser() {
        val user = userMapper.queryUserById(1)
        println(user)
        println("===============修改后，注意age+1，updated也变了===============")
        user.password = "assd"
        user.updated = System.currentTimeMillis()
        var age = user.age ?: 0
        user.age = age + 1

        this.userMapper.updateUser(user)
        this.sqlSession.commit()

        println(userMapper.queryUserById(1))


    }

    @Test
    fun deleteUser() {
        this.userMapper.deleteUser("6")
        this.sqlSession.commit()
    }


    /**
     * 如何利用#{}来传递like的值
     */
    @Test
    fun queryUserList() {

        val name = "呦呦"
        val users = this.userMapper.queryUserList("%$name%")
        for (user in users) {
            println(user)
        }
    }

    @Test
    fun query() {
        val condition = UserCondition(name = "刘", sex = true, age = 17)
        val map = userMapper.query(condition)
        map.forEach { println(it) }

    }
}