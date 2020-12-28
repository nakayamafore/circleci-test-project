package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.constant.ShopTripConstants.Endpoint;
import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeFindByConditionRequest;
import com.example.demo.model.EmployeeRegisterRequest;
import com.example.demo.model.EmployeeRegisterResponse;
import com.example.demo.model.domain.EmployeeFindByCondition;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Endpoint.EMPLOYEE)
@RequiredArgsConstructor
public class EmployeeController {

  private final ModelMapper mapper;
  private final EmployeeService employeeService;

  @GetMapping(Endpoint.CONDITION)
  public List<EmployeeRegisterResponse> findByCondition(
      EmployeeFindByConditionRequest request) {

    Sort sort = Sort.by(Order.desc("id"));
    Pageable pageable = PageRequest.of(request.getOffset(), request.getSize(), sort);
    Page<Employee> result =
        employeeService.findByConditionWithPageable(
            mapper.map(request, EmployeeFindByCondition.class), pageable);
    System.out.println("TotalCount:" + result.getTotalElements());
    System.out.println("TotalPages:" + result.getTotalPages());
    return result.getContent().stream()
        .map(e -> mapper.map(e, EmployeeRegisterResponse.class))
        .collect(Collectors.toList());
  }

  @PostMapping
  public EmployeeRegisterResponse save(
      @RequestBody @Validated EmployeeRegisterRequest request) {
    Employee employee = mapper.map(request, Employee.class);
    return mapper.map(employeeService.save(employee), EmployeeRegisterResponse.class);
  }

  @GetMapping
  public List<EmployeeRegisterResponse> find() {
    List<Employee> resutl = employeeService.findAll();
    return resutl.stream().map(e -> mapper.map(e, EmployeeRegisterResponse.class))
        .collect(Collectors.toList());
  }

  @DeleteMapping(Endpoint.EMPLOYEE_ID)
  public void remove(@PathVariable("employeeId") Long employeeId) {
    employeeService.delete(employeeId);
  }
}
