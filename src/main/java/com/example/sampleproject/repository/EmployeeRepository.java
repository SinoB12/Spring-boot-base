package com.example.sampleproject.repository;

import com.example.sampleproject.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface EmployeeRepository {

    int insert(Employee employee);

    List<Employee> findAll();

    Long countAll();

    Employee findById(@Param("id") String id);

    Employee findByEmail(@Param("email") String email);

    List<GrantedAuthority> findListRoleById(@Param("id") String id);
}
