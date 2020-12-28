package com.example.demo.entity.key;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomsSchedulesKey implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "classroom_id")
  private Long classroomId;
  @Column(name = "schedule_id")
  private Long scheduleId;
}
