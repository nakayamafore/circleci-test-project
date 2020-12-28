package com.example.demo.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
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
public class EmployeeFindByConditionRequest {
  private Long id;
  private String firstName;
  private String lastName;
  private Sex sex;
  @DateTimeFormat(pattern = "yyyy/M/d")
  private LocalDate birthday;
  private String mailAddress;
  private int offset;
  private int size;
}
