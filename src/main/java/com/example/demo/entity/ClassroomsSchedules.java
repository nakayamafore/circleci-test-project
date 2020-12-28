package com.example.demo.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.example.demo.config.ZonedDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomsSchedules implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  @JoinColumn
  @JsonIgnore
  private Classrooms classrooms;
  // @Convert(converter = ZonedDateTimeConverter.class)
  private ZonedDateTime startsAt;
  @Convert(converter = ZonedDateTimeConverter.class)
  private ZonedDateTime endsAt;
  private String zoomUrl;
  private String zoomPassword;

  @OneToMany(mappedBy = "classroomsSchedules")
  List<ClassroomsReservations> classroomsReservations;

}
