package com.backend.ifxnetworks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.ifxnetworks.model.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	@Query("SELECT e FROM EmployeeEntity e WHERE document = :document")
    List<EmployeeEntity> findByDocument(@Param("document") Long document);
	
}
