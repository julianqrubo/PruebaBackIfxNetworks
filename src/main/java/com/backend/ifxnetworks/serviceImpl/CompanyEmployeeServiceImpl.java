package com.backend.ifxnetworks.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.ifxnetworks.Utils.EntityUtils;
import com.backend.ifxnetworks.model.CompanyEmployeeEntity;
import com.backend.ifxnetworks.repository.CompanyEmployeeRepository;
import com.backend.ifxnetworks.service.CompanyEmployeeService;

@Component
public class CompanyEmployeeServiceImpl implements CompanyEmployeeService {

	@Autowired
	CompanyEmployeeRepository companyEmployeeRepository;

	@Override
	public Optional<CompanyEmployeeEntity> getById(Long id) {
		return companyEmployeeRepository.findById(id);
	}

	@Override
	public List<CompanyEmployeeEntity> getAll() {
		return companyEmployeeRepository.findAll();
	}

	@Override
	public Long create(CompanyEmployeeEntity entity) {
		entity.setDateCreated(EntityUtils.getCurrentDate());
		entity.setDateUpdated(entity.getDateCreated());
		CompanyEmployeeEntity newRow = companyEmployeeRepository.save(entity);
		return newRow.getId();
	}

	@Override
	public void update(Long id, CompanyEmployeeEntity entity) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Long id) {
		companyEmployeeRepository.deleteById(id);
	}
}
