package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.entity.Employee;
import com.example.demo.model.domain.EmployeeFindByCondition;

public interface EmployeeService {
  public Employee save(Employee entity);

  public List<Employee> findAll();

  public List<Employee> getEmployeeList();

  public void delete(Long employeeId);

  public List<Employee> findByCondition(EmployeeFindByCondition map);

  public Page<Employee> findByConditionWithPageable(EmployeeFindByCondition condition,
      Pageable pageable);
}
