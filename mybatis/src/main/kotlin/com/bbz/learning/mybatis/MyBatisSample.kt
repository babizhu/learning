package com.bbz.learning.mybatis

import com.bbz.learning.mybatis.dto.User
import org.apache.ibatis.io.Resources
import org.apache.ibatis.session.SqlSessionFactoryBuilder

/**
 * 最简单的流程展示
 */
class MyBatisSample {

    fun run() {
        val resource = "mybatis-config.xml"
        // 读取配置文件
        val inputStream = Resources.getResourceAsStream(resource)
        // 构建sqlSessionFactory
        val sqlSessionFactory = SqlSessionFactoryBuilder().build(inputStream)
        // 获取sqlSession
        val sqlSession = sqlSessionFactory.openSession()
        try {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            val user = sqlSession.selectOne<User>("UserMapper.selectUser", 1)
            println(user)
        } finally {
            sqlSession.close()
            inputStream.close()
        }
    }
}
