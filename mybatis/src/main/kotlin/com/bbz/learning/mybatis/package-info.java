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
 * Q: #{}多个参数时
 * A: #{0},#{1},来进行占位，或者使用在方法中使用@Param("userName")来向mapper文件中传递#{userName}参数，比如：
 *      public User login(@Param("userName") String userName, @Param("password") String password);
 *
 *      <select id="login" resultType="com.zpc.mybatis.pojo.User">
 *          select * from tb_user where user_name = #{userName} and password = #{password}
 *      </select>
 *
 *  Q: 如何返回一个Hashmap
 *  A:
 *      1、在接口的方法上，指名key
 *          @MapKey("id")
 *          fun queryAllMap(): Map<Int, LoginRecord>
 *      2、在xml中
 *          <select id="queryAllMap" resultMap="resultLoginRecord"> 详见 mappers/loginRecordMapper.xml
 *
 * 大坑
 *      两个表联合查询大时候，sql语句当中千万不要存在相同的字段名例如o.id,u.id之类的，虽然在sql层面已经做了区分，但是mybatis区分不了，
 *      都是id。这样会出一些莫名其妙的问题
 *
 */

