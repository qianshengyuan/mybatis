/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.jiyuan.test;

import com.jiyuan.test.bean.Department;
import com.jiyuan.test.bean.Person;
import com.jiyuan.test.dao.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
  public static void main(String[] args) throws IOException {
    // 加载全局配置文件
    InputStream xml = Resources.getResourceAsStream("mybatis-config.xml");
    // 获取SqlSessionFactory工厂对象
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(xml);
    // 获取SqlSession对象，这一步会创建executor对象
    SqlSession sqlSession = sqlSessionFactory.openSession();
    // 获取mapper接口的代理对象
    // 使用MapperProxyFactory创建一个MapperProxy的代理对象，代理对象里面包含了DefaultSqlSession(Executor)
    DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
    // 使用接口的代理对象去实现增删改查
    // 动态代理，会直接执行代理对象的invoke方法  MapperProxy实际也是一个InvocationHandler
    // List<Department> list = mapper.findAll();
    // System.out.println(list);
    Department department = mapper.findById("18ec781fbefd727923b0d35740b177ab");
    System.out.println(department);

    MetaObject metaObject = SystemMetaObject.forObject(new Person());
    System.out.println(metaObject);
    System.out.println(metaObject.getValue("name"));
    metaObject.setValue("name","李四");
    System.out.println(metaObject.getValue("name"));
    System.out.println(metaObject.getValue("hobby"));
    metaObject.setValue("hobby",new HashMap<>());
    metaObject.setValue("hobby[swim]",true);
    System.out.println(metaObject.getValue("hobby"));

  }
}
