package com.bbz.learning.mybatis.mapper.impl

import com.bbz.learning.mybatis.dto.User
import com.bbz.learning.mybatis.dto.UserCondition
import com.bbz.learning.mybatis.mapper.UserMapper
import org.apache.ibatis.session.SqlSession


class UserMapperImpl(private val sqlSession: SqlSession) : UserMapper {
    override fun query(condition: UserCondition): Map<Int, User> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun queryUserList(name: String?): List<User> {
        return this.sqlSession.selectList("UserMapper.queryUserList")
    }

    override fun queryUserAllMap(): Map<Int, User> {
        return this.sqlSession.selectMap<Int,User>("UserMapper.queryUserByIdMap","id")
    }

    override fun queryUserById(id: Int): User {
        return this.sqlSession.selectOne("UserMapper.queryUserById", id)
    }

    override fun queryUserAll(): List<User> {
        return this.sqlSession.selectList("UserMapper.queryAll")
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