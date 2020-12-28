package com.example.demo.repository.spec;

import java.time.ZonedDateTime;
import java.util.Objects;
import javax.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import com.example.demo.entity.Classrooms;

public class ClassroomsSpec {
  public static Specification<Classrooms> title(String title) {
    return Objects.isNull(title) || title.isEmpty() ? null
        : (root, query, cb) -> cb.like(root.<String>get("title"),
            "%" + title + "%");
  }

  public static Specification<Classrooms> blandName(String brandName) {
    return Objects.isNull(brandName) || brandName.isEmpty() ? null
        : (root, query, cb) -> cb.like(
            root.join("brands", JoinType.LEFT).get("name"), "%" + brandName + "%");
  }

  public static Specification<Classrooms> zoomUrl(String zoomUrl) {
    return Objects.isNull(zoomUrl) || zoomUrl.isEmpty() ? null
        : (root, query, cb) -> cb.like(
            root.join("schedules", JoinType.LEFT).get("zoomUrl"), "%" + zoomUrl + "%");
  }

  public static Specification<Classrooms> email(String email) {
    return Objects.isNull(email) || email.isEmpty() ? null
        : (root, query, cb) -> cb.like(
            root.join("schedules", JoinType.LEFT)
                .join("classroomsReservations", JoinType.LEFT).get("email"),
            "%" + email + "%");
  }

  public static Specification<Classrooms> rangeStart(ZonedDateTime fromAt,
      ZonedDateTime toAt) {
    if (Objects.isNull(fromAt) || Objects.isNull(toAt)) {
      return null;
    }
    return (root, query, cb) -> cb.between(
        root.join("schedules", JoinType.LEFT).get("startsAt"), fromAt, toAt);
  }
}
