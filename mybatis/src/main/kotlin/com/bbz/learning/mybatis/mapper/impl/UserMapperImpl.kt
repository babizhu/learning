package com.bbz.learning.mybatis.mapper.impl

import com.bbz.learning.mybatis.dto.User
import com.bbz.learning.mybatis.mapper.UserMapper
import org.apache.ibatis.session.SqlSession


class UserMapperImpl(private val sqlSession: SqlSession) : UserMapper {

    override fun queryUserById(id: Int): User {
        return this.sqlSession.selectOne("UserMapper.queryUserById", id)
    }

    override fun queryUserAll(): List<User> {
        return this.sqlSession.selectList("UserMapper.queryUserAll")
    }

    override fun insertUser(user: User) {
        this.sqlSession.insert("UserMapper.insertUser", user)
    }

    override fun updateUser(user: User) {
        this.sqlSession.update("UserMapper.updateUser", user)
    }

    override fun deleteUser(id: String) {
        this.sqlSession.delete("UserMapper.deleteUser", id)
    }
}