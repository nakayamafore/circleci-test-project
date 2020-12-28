package com.example.demo.model.domain;

import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ClassroomsFindByCondition {
  private String title;
  private String brandName;
  private String zoomUrl;
  private String email;
  private ZonedDateTime fromAt;
  private ZonedDateTime toAt;
  private int offset;
  private int size;
}
