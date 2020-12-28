package com.example.demo.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import com.example.demo.entity.Brands;
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
public class ClassroomsFindResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String title;
  private String summary;
  private String body;
  private String thumbnailUrl;
  private Long teacherId;
  private Boolean isFree;
  private Boolean canUseFreeTicket;
  private Boolean isRecommended;
  private Long unitPrice;
  private Long capacity;
  private String freeMetaTag;
  private ZonedDateTime displayStartsAt;
  private ZonedDateTime displayEndsAt;
  private ZonedDateTime reservationStartsAt;
  private List<Brands> classroomsBrands;
  private List<ClassroomsSchedulesFindResponse> schedules;
}
