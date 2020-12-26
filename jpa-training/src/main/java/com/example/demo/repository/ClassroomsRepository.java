package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Classrooms;

@Repository
public interface ClassroomsRepository
    extends JpaRepository<Classrooms, Long>, JpaSpecificationExecutor<Classrooms> {

  @EntityGraph(value = "classrooms-entity-graph")
  Page<Classrooms> findAll(Specification<Classrooms> spec, Pageable pageable);
}
