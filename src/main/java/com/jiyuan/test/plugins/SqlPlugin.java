package com.jiyuan.test.plugins;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * 自定义插件，实现sql语句的拦截
 */
@Intercepts(@Signature(
  type = StatementHandler.class,
  method = "prepare",
  args = {
    Connection.class,
    Integer.class
  }
))
public class SqlPlugin implements Interceptor {
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
    String sql = statementHandler.getBoundSql().getSql();
    System.out.println("执行sql语句：" + sql);
    return invocation.proceed();
  }

  @Override
  public Object plugin(Object target) {
    System.out.println("插件进行包装，返回代理对象");
    return Plugin.wrap(target, this);
  }

  @Override
  public void setProperties(Properties properties) {
    // 不操作
  }
}
