package com.backend.ifxnetworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.ifxnetworks.model.CompanyEmployeeEntity;

@Repository
public interface CompanyEmployeeRepository extends JpaRepository<CompanyEmployeeEntity, Long> {

}
