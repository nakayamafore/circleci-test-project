package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Brands;

@Repository
public interface ClassroomsBrandsRepository
    extends JpaRepository<Brands, Long>,
    JpaSpecificationExecutor<Brands> {
}
