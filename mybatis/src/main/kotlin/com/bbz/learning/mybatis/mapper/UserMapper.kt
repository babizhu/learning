package com.bbz.learning.mybatis.mapper

import com.bbz.learning.mybatis.dto.User


interface UserMapper {
    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    fun queryUserById(id: Int): User

    /**
     * 查询所有用户信息
     *
     * @return
     */
    fun queryUserAll(): List<User>

    /**
     * 新增用户
     *
     * @param user
     */
    fun insertUser(user: User)

    /**
     * 更新用户信息
     *
     * @param user
     */
    fun updateUser(user: User)

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    fun deleteUser(id: String)
}