package com.example.demo.model;

import java.time.LocalDate;
import java.util.Objects;
import javax.validation.constraints.AssertTrue;
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
public class EmployeeRegisterRequest {
  private String firstName;
  private String lastName;
  private Sex sex;
  @JsonFormat(pattern = "yyyy/M/d")
  private LocalDate birthday;
  private String mailAddress;
  private Long departmentId;

  @AssertTrue(message = "{validation.date-empty}")
  public boolean isFirstName() {
    if (!Objects.isNull(firstName) && Objects.isNull(lastName)) {
      return false;
    }
    return true;
  }
}
