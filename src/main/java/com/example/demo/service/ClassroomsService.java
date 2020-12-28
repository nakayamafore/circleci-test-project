package com.example.demo.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.demo.entity.Classrooms;
import com.example.demo.model.domain.ClassroomsFindByCondition;

public interface ClassroomsService {
  void init();

  List<Classrooms> findAll();

  List<Classrooms> findByCondition(ClassroomsFindByCondition condition);

  Page<Classrooms> findByCondition(ClassroomsFindByCondition condition,
      Pageable pageable);
}
