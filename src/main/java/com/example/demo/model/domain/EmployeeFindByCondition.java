package com.example.demo.model.domain;

import java.time.LocalDate;
import com.example.demo.enumType.Sex;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeFindByCondition {
  private Long id;
  private String firstName;
  private String lastName;
  private Sex sex;
  private LocalDate birthdayFrom;
  private LocalDate birthdayTo;
  private String mailAddress;
}
