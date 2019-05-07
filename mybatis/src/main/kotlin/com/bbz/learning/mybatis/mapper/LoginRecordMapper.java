package com.bbz.learning.mybatis.mapper;

import com.bbz.learning.mybatis.dto.LoginRecord;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface LoginRecordMapper {
    /**
     * //     * 根据id查询用户信息
     * //     *
     * //     * @param id
     * //     * @return
     * //
     */
    LoginRecord queryById(int id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    List<LoginRecord> queryAll();

    @MapKey("id")
    Map<Integer, LoginRecord> queryAllMap();
//
//    /**
//     * 新增用户
//     *
//     * @param user
//     */
//    fun insertUser(user: User)
//
//    /**
//     * 更新用户信息
//     *
//     * @param user
//     */
//    fun updateUser(user: User)
//
//    /**
//     * 根据id删除用户信息
//     *
//     * @param id
//     */
//    fun deleteUser(id: String)

    default void foo(){
        System.out.println("xyz");
    }

}
