package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.example.demo.enumType.Sex;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Employee extends Audit implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 20, nullable = false)
  private String firstName;
  @Column(length = 20, nullable = false)
  private String lastName;
  @Column(length = 10)
  @Enumerated(EnumType.STRING)
  private Sex sex;
  private LocalDate birthday;
  @Column(unique = true)
  private String mailAddress;
  @ManyToOne
  @JoinColumn(name = "departmentId", referencedColumnName = "id")
  private Department department;
}
