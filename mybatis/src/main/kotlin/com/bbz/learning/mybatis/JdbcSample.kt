package com.bbz.learning.mybatis


import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.PreparedStatement


/**
 * 采用原始的jdbc进行数据库操作
 */
class JdbcSample {
}

@Throws(Exception::class)
fun main() {
    var connection: Connection? = null
    var prepareStatement: PreparedStatement? = null
    var rs: ResultSet? = null

    try {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver")
        // 获取连接
        val url = "jdbc:mysql://127.0.0.1:3306/spring?useSSL=false"
        val user = "root"
        val password = "123456"
        connection = DriverManager.getConnection(url, user, password)

        // 获取statement，preparedStatement
        val sql = "select * from user where id=?"
        prepareStatement = connection!!.prepareStatement(sql)
        // 设置参数
        prepareStatement!!.setLong(1, 1L)
        // 执行查询
        rs = prepareStatement.executeQuery()
        // 处理结果集
        while (rs!!.next()) {
            println(rs.getString("name"))
            println(rs.getInt("age"))
        }
    } finally {
        // 关闭连接，释放资源
        rs?.close()
        prepareStatement?.close()

        connection?.close()
    }
}