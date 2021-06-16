package com.jiyuan.test.dao;

import com.jiyuan.test.bean.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {

    List<Department> findAll();

    Department findById(String id);

    int insert(Department department);

    int update(Department department);

    int deleteById(String id);

}
