//package com.bbz.learning.mybatis.plugin
//
//import org.apache.ibatis.executor.Executor
//import java.util.Properties
//import org.apache.ibatis.plugin.Invocation
//import org.apache.ibatis.plugin.Interceptor
//import org.apache.ibatis.mapping.MappedStatement
//import org.apache.ibatis.plugin.Intercepts
//import org.apache.ibatis.plugin.Signature
//
//
//@Intercepts(Signature(type = Executor::class, method = "update", args = { MappedStatement::class.java,
//    MappedStatement::class.java }))
//class ExamplePlugin : Interceptor {
//    @Throws(Throwable::class)
//    override fun intercept(invocation: Invocation): Any {
//        return invocation.proceed()
//    }
//
//    override fun plugin(target: Any): Any {
//        return Plugin.wrap(target, this)
//    }
//
//    override fun setProperties(properties: Properties) {}
//}