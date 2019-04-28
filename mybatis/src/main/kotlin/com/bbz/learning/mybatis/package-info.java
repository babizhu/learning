package com.bbz.learning.mybatis;
/**
 * 来源：https://blog.csdn.net/hellozpc/article/details/80878563
 *
 * 开启动态代理之后需要注意：
 * 1、配置文件中到namespace必须为Mapper接口的全路径，例如：com.bbz.learning.mybatis.mapper.UserMapper
 * 2、id必须等于方法名
 * 3、resultType必须等于方法的返回值的类型
 * 4、parameterType必须等于方法的参数类型（不一定？）
 *
 * Q: 数据库字段名和实体类属性名不一致
 * A: 方案一：可以在sql语句上使用别名，例如  select tuser.user_name as userName from tb_user tuser
 *    方案二：resultMap
 *    方案三：
 *          <settings>
 *              <setting name="mapUnderscoreToCamelCase" value="true"/>
 *          </settings>
 *
 * Q: properties的优先级
 * A:   1）在 properties 元素体内指定的属性首先被读取。
 *      2）然后根据 properties 元素中的 resource 属性读取类路径下属性文件或根据 url 属性指定的路径读取属性文件，并覆盖已读取的同名属性。
 *      3）最后读取作为方法参数传递的属性，并覆盖已读取的同名属性。
 *
 */

