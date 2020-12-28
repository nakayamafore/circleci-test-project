package com.example.demo.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Employee;
import com.example.demo.model.domain.EmployeeFindByCondition;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.spec.EmployeeSpec;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

  @PersistenceContext
  private EntityManager entityManager;

  private final EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getEmployeeList() {
    return entityManager.createQuery("SELECT e from Employee e", Employee.class)
        .getResultList();
  }

  @Override
  public Employee save(Employee entity) {
    return employeeRepository.save(entity);
  }

  @Override
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public void delete(Long employeeId) {
    employeeRepository.deleteById(employeeId);
  }

  @Override
  public List<Employee> findByCondition(EmployeeFindByCondition condition) {

    return employeeRepository
        .findAll(Specification.where(
            EmployeeSpec.firstName(condition.getFirstName()))
            .and(EmployeeSpec.lastName(condition.getLastName()))
            .and(EmployeeSpec.birthdayRange(condition.getBirthdayFrom(),
                condition.getBirthdayTo())));
  }

  @Override
  public Page<Employee> findByConditionWithPageable(EmployeeFindByCondition condition,
      Pageable pageable) {
    return employeeRepository
        .findAll(Specification.where(
            EmployeeSpec.firstName(condition.getFirstName()))
            .and(EmployeeSpec.lastName(condition.getLastName()))
            .and(EmployeeSpec.birthdayRange(condition.getBirthdayFrom(),
                condition.getBirthdayTo())),
            pageable);
  }
}
