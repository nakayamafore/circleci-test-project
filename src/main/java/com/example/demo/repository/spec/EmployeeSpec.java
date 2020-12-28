package com.example.demo.repository.spec;

import java.time.LocalDate;
import java.util.Objects;
import org.springframework.data.jpa.domain.Specification;
import com.example.demo.entity.Employee;

public class EmployeeSpec {
  public static Specification<Employee> firstName(String firstName) {
    return Objects.isNull(firstName) || firstName.isEmpty() ? null
        : (root, query, cb) -> cb.like(root.<String>get("firstName"),
            "%" + firstName + "%");
  }

  public static Specification<Employee> lastName(String lastName) {
    return Objects.isNull(lastName) || lastName.isEmpty() ? null
        : (root, query, cb) -> cb.like(root.<String>get("lastName"),
            "%" + lastName + "%");
  }

  public static Specification<Employee> birthdayRange(LocalDate from, LocalDate to) {
    return Objects.isNull(from) || Objects.isNull(to) ? null
        : (root, query, cb) -> cb.between(root.<LocalDate>get("birthday"), from, to);
  }
}
