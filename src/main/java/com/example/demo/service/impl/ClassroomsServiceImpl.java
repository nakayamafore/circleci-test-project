package com.example.demo.service.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Brands;
import com.example.demo.entity.Classrooms;
import com.example.demo.entity.ClassroomsReservations;
import com.example.demo.entity.ClassroomsSchedules;
import com.example.demo.model.domain.ClassroomsFindByCondition;
import com.example.demo.repository.ClassroomsBrandsRepository;
import com.example.demo.repository.ClassroomsRepository;
import com.example.demo.repository.ClassroomsReservationsRepository;
import com.example.demo.repository.ClassroomsSchedulesRepository;
import com.example.demo.repository.spec.ClassroomsSpec;
import com.example.demo.service.ClassroomsService;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ClassroomsServiceImpl implements ClassroomsService {

  @PersistenceContext
  private EntityManager entityManager;

  private final ClassroomsRepository classroomsRepository;
  private final ClassroomsBrandsRepository classroomsBrandsRepository;
  private final ClassroomsReservationsRepository classroomsReservationsRepository;
  private final ClassroomsSchedulesRepository classroomsSchedulesRepository;

  @Override
  public List<Classrooms> findAll() {
    return classroomsRepository.findAll();
  }

  @Override
  public Page<Classrooms> findByCondition(ClassroomsFindByCondition condition,
      Pageable pageable) {
    return classroomsRepository
        .findAll(Specification.where(
            ClassroomsSpec.zoomUrl(condition.getZoomUrl())
                .and(ClassroomsSpec.email(condition.getEmail()))
                .and(ClassroomsSpec.rangeStart(
                    condition.getFromAt(),
                    condition.getToAt()))),
            pageable);
  }

  @Override
  public void init() {

    // ReservationMembers reservationMembers1 =
    // ReservationMembers.builder()
    // .nickname("nick01")
    // .memberId(1L)
    // .build();
    // reservationMembersRepository.save(reservationMembers1);
    // ReservationMembers reservationMembers2 =
    // ReservationMembers.builder()
    // .nickname("nick02")
    // .memberId(2L)
    // .build();
    // reservationMembersRepository.save(reservationMembers2);
    //
    List<Brands> brands = List.of(
        Brands.builder()
            .code("100")
            .name("brand1")
            .build(),
        Brands.builder()
            .code("200")
            .name("brand2")
            .build());
    classroomsBrandsRepository.saveAll(brands);


    Classrooms classrooms = Classrooms.builder()
        .body("body1")
        .title("title1")
        .summary("summary1")
        .body("body1")
        .thumbnailUrl("thumbnailUrl1")
        .teacherId(1L)
        .isFree(true)
        .canUseFreeTicket(true)
        .isRecommended(true)
        .unitPrice(1000L)
        .capacity(20L)
        .freeMetaTag("freeMetaTag1")
        .displayStartsAt(
            ZonedDateTime.of(2020, 12, 1, 12, 00, 0, 0, ZoneId.systemDefault()))
        .displayEndsAt(
            ZonedDateTime.of(2020, 12, 31, 12, 00, 0, 0, ZoneId.systemDefault()))
        .reservationStartsAt(
            ZonedDateTime.of(2020, 12, 7, 12, 00, 0, 0, ZoneId.systemDefault()))
        .brands(brands)
        .build();
    classroomsRepository.save(classrooms);

    ClassroomsSchedules schedules1 = ClassroomsSchedules.builder()
        .classrooms(classrooms)
        .startsAt(ZonedDateTime.now())
        .endsAt(ZonedDateTime.now())
        .zoomUrl("zoomUrl1")
        .zoomPassword("zoomPassword1")
        .build();
    classroomsSchedulesRepository.save(schedules1);

    ClassroomsSchedules schedules2 = ClassroomsSchedules.builder()
        .classrooms(classrooms)
        .startsAt(ZonedDateTime.now())
        .endsAt(ZonedDateTime.now())
        .zoomUrl("zoomUrl2")
        .zoomPassword("zoomPassword2")
        .build();
    classroomsSchedulesRepository.save(schedules2);

    ClassroomsReservations reservations1 = ClassroomsReservations.builder()
        .classroomsSchedules(schedules1)
        .reservedAt(ZonedDateTime.now())
        .familyId(1L)
        .email("email1")
        .freeTicketsNumber(1L)
        .paymentAmount(1L)
        .build();
    classroomsReservationsRepository.save(reservations1);
    ClassroomsReservations reservations11 = ClassroomsReservations.builder()
        .classroomsSchedules(schedules1)
        .reservedAt(ZonedDateTime.now())
        .familyId(11L)
        .email("email11")
        .freeTicketsNumber(1L)
        .paymentAmount(1L)
        .build();
    classroomsReservationsRepository.save(reservations11);

    ClassroomsReservations reservations2 = ClassroomsReservations.builder()
        .classroomsSchedules(schedules2)
        .reservedAt(ZonedDateTime.now())
        .familyId(2L)
        .email("email2")
        .freeTicketsNumber(2L)
        .paymentAmount(2L)
        .build();
    classroomsReservationsRepository.save(reservations2);
    ClassroomsReservations reservations22 = ClassroomsReservations.builder()
        .classroomsSchedules(schedules2)
        .reservedAt(ZonedDateTime.now())
        .familyId(22L)
        .email("email22")
        .freeTicketsNumber(2L)
        .paymentAmount(2L)
        .build();
    classroomsReservationsRepository.save(reservations22);

    Classrooms classrooms2 = Classrooms.builder()
        .body("body2")
        .title("title2")
        .summary("summary2")
        .body("body2")
        .thumbnailUrl("thumbnailUrl2")
        .teacherId(1L)
        .isFree(true)
        .canUseFreeTicket(true)
        .isRecommended(true)
        .unitPrice(1000L)
        .capacity(20L)
        .freeMetaTag("freeMetaTag2")
        .displayStartsAt(
            ZonedDateTime.of(2020, 12, 1, 12, 00, 0, 0, ZoneId.systemDefault()))
        .displayEndsAt(
            ZonedDateTime.of(2020, 12, 31, 12, 00, 0, 0, ZoneId.systemDefault()))
        .reservationStartsAt(
            ZonedDateTime.of(2020, 12, 7, 12, 00, 0, 0, ZoneId.systemDefault()))
        .brands(brands)
        .build();
    classroomsRepository.save(classrooms2);

  }

  @Override
  public List<Classrooms> findByCondition(ClassroomsFindByCondition condition) {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }
}
