package com.backend.ifxnetworks.service;

import java.util.List;

import com.backend.ifxnetworks.model.EmployeeEntity;

public interface EmployeeService extends SuperCrud<EmployeeEntity> {

	List<EmployeeEntity> findByDocument(Long document);
	
	Long createRealtionCompanyEmployee(Long companyId, EmployeeEntity entity);
}
