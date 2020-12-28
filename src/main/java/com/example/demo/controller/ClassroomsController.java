package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.constant.ShopTripConstants.Endpoint;
import com.example.demo.entity.Classrooms;
import com.example.demo.model.ClassroomsFindResponse;
import com.example.demo.model.domain.ClassroomsFindByCondition;
import com.example.demo.service.ClassroomsService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(Endpoint.CLASSROOMS)
@RequiredArgsConstructor
public class ClassroomsController {

  private final ModelMapper mapper;
  private final ClassroomsService classroomsService;


  @PostMapping(Endpoint.INIT)
  public void init() {
    classroomsService.init();
  }

  @GetMapping
  public List<ClassroomsFindResponse> find() {
    List<Classrooms> result = classroomsService.findAll();
    return result.stream().map(e -> mapper.map(e, ClassroomsFindResponse.class))
        .collect(Collectors.toList());
  }

  @GetMapping(Endpoint.CONDITION)
  public List<ClassroomsFindResponse> findByCondition(
      @RequestBody ClassroomsFindByCondition condition) {
    Sort sort = Sort.by(Order.desc("id"));
    Pageable pageable = PageRequest.of(condition.getOffset(), condition.getSize(), sort);
    Page<Classrooms> result = classroomsService.findByCondition(condition, pageable);

    List<ClassroomsFindResponse> res =
        result.stream()
            .map(e -> mapper.map(e, ClassroomsFindResponse.class))
            .collect(Collectors.toList());

    List<ClassroomsFindResponse> res2 =
        result.stream()
            .map(e -> {
              ClassroomsFindResponse re = mapper.map(e, ClassroomsFindResponse.class);
              return re;
            }).collect(Collectors.toList());

    return res;
  }
}
