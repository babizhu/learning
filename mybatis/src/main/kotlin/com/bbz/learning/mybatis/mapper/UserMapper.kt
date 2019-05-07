package com.bbz.learning.mybatis.mapper

import com.bbz.learning.mybatis.dto.User
import com.bbz.learning.mybatis.dto.UserCondition
import org.apache.ibatis.annotations.MapKey
import org.apache.ibatis.annotations.Param




interface UserMapper {
    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
//    fun queryUserById(id: String): User
    fun queryUserById(id: Int): User

    /**
     * 查询所有用户信息
     *
     * @return
     */
    fun queryUserAll(): List<User>

    @MapKey("id")
    fun queryUserAllMap():Map<Int,User>
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

    /**
     * 动态查询
     * 查询男性用户
     * 如果输入了姓名，则where子句中增加姓名查询条件
     */

    fun queryUserList(@Param("name") name: String?):List<User>

    /**
     * 动态查询，条件组合
     */
    @MapKey("id")
    fun query(condition: UserCondition):Map<Int,User>
}