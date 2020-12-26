package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.constant.ShopTripConstants.Endpoint;
import com.example.demo.entity.Department;
import com.example.demo.model.DepartmentRegisterRequest;
import com.example.demo.model.DepartmentRegisterResponse;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Endpoint.DEPARTMENT)
@RequiredArgsConstructor
public class DepartmentController {

  private final ModelMapper mapper;
  private final DepartmentService employeeService;

  @PostMapping
  public DepartmentRegisterResponse save(@RequestBody DepartmentRegisterRequest request) {
    Department department = mapper.map(request, Department.class);
    return mapper.map(employeeService.save(department), DepartmentRegisterResponse.class);
  }
}
