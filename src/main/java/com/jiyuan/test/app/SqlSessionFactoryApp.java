package com.jiyuan.test.app;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Step 1 : 加载配置文件，创建SqlSessionFactory
 * 会创建一个Configuration对象，包含全局配置文件与mapper映射文件
 * 通过configuration对象，创建一个DefaultSqlSessionFactory对象
 * @author yuan
 * @create 2021-06-01 9:49
 */
public class SqlSessionFactoryApp {
  public static void main(String[] args) throws IOException {
    // 从配置文件中创建一个输入流
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    // 工厂模式
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
    System.out.println(sqlSessionFactory.getClass());
  }
}
