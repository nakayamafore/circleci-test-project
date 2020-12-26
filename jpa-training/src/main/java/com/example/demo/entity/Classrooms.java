package com.example.demo.entity;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@NamedEntityGraph(
    name = "classrooms-entity-graph",
    attributeNodes = {
        @NamedAttributeNode("schedules"),
    // @NamedAttributeNode("brands"),
    })
public class Classrooms extends Audit implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 20, nullable = false)
  private String title;
  @Column(length = 200, nullable = false)
  private String summary;
  @Column(length = 2000, nullable = false)
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

  @OneToMany(mappedBy = "classrooms")
  List<ClassroomsSchedules> schedules;

  @ManyToMany
  @JoinColumn(name = "blandId", referencedColumnName = "id")
  private List<Brands> brands;
}
