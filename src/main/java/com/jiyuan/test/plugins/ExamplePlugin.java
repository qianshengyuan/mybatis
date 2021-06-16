package com.jiyuan.test.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

// 表示对四大对象的Executor对象（可以改成其他对象）的query方法（对象中的方法）进行拦截增强，参数为该方法中的参数
@Intercepts({@Signature(type = Executor.class,method = "query", args = {
  MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
})})
public class ExamplePlugin implements Interceptor {
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    System.out.println("自定义插件ExamplePlugin进行了增强");
    return invocation.proceed();
  }
}
