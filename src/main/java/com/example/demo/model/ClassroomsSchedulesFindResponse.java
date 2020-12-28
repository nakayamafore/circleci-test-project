package com.example.demo.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomsSchedulesFindResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Long classroomsId;
  private ZonedDateTime startsAt;
  private ZonedDateTime endsAt;
  private String zoomUrl;
  private String zoomPassword;
  private int reservationCount;
}
