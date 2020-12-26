package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;
import com.example.demo.entity.Department;
import com.example.demo.enumType.Sex;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeRegisterResponse {
  private Long id;
  private String firstName;
  private String lastName;
  private Sex sex;
  @JsonFormat(pattern = "yyyy/M/d")
  private LocalDate birthday;
  private String mailAddress;
  private List<Department> departments;
}
