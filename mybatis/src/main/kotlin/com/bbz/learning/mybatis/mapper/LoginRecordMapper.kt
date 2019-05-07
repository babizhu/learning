//package com.bbz.learning.mybatis.mapper
//
//import com.bbz.learning.mybatis.dto.LoginRecord
//import org.apache.ibatis.annotations.MapKey
//
//
//interface LoginRecordMapper {
//    /**
//     * 根据id查询用户信息
//     *
//     * @param id
//     * @return
//     */
//    fun queryById(id: Int): LoginRecord
//
//    /**
//     * 查询所有用户信息
//     *
//     * @return
//     */
//    fun queryAll(): List<LoginRecord>
//
//    @MapKey("id")
//    fun queryAllMap(): Map<Int, LoginRecord>
////
////    /**
////     * 新增用户
////     *
////     * @param user
////     */
////    fun insertUser(user: User)
////
////    /**
////     * 更新用户信息
////     *
////     * @param user
////     */
////    fun updateUser(user: User)
////
////    /**
////     * 根据id删除用户信息
////     *
////     * @param id
////     */
////    fun deleteUser(id: String)
//
//
//
//}