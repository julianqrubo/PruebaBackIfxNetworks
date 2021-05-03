package com.backend.ifxnetworks.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.ifxnetworks.Utils.EntityUtils;
import com.backend.ifxnetworks.model.CompanyEmployeeEntity;
import com.backend.ifxnetworks.model.EmployeeEntity;
import com.backend.ifxnetworks.repository.CompanyEmployeeRepository;
import com.backend.ifxnetworks.repository.EmployeeRepository;
import com.backend.ifxnetworks.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	CompanyEmployeeRepository companyEmployeeRepository;

	@Override
	public Optional<EmployeeEntity> getById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<EmployeeEntity> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Long create(EmployeeEntity entity) {
		entity.setDateCreated(EntityUtils.getCurrentDate());
		entity.setDateUpdated(entity.getDateCreated());
		EmployeeEntity newRow = employeeRepository.save(entity);
		return newRow.getId();
	}

	@Override
	public void update(Long id, EmployeeEntity entity) {
		boolean existsById = employeeRepository.existsById(id);
		if (existsById) {
			Optional<EmployeeEntity> employee = employeeRepository.findById(id);
			EmployeeEntity employeeEntity = employee.get();
			employeeEntity.setDateUpdated(EntityUtils.getCurrentDate());
			employeeEntity.setName(entity.getName());
			employeeEntity.setEmail(entity.getEmail());
			employeeEntity.setPhone(entity.getPhone());
			employeeRepository.saveAndFlush(employeeEntity);
		} else {
			throw new RuntimeException("No se encontró el registro para actualizar");
		}
	}

	@Override
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeEntity> findByDocument(Long document) {
		return employeeRepository.findByDocument(document);
	}

	@Override
	public Long createRealtionCompanyEmployee(Long companyId, EmployeeEntity entity) {
		Long document = entity.getDocument();
		List<EmployeeEntity> findByDocument = findByDocument(document);
		long id = 0l;
		if (findByDocument.size() == 0) {
			entity.setDateCreated(EntityUtils.getCurrentDate());
			entity.setDateUpdated(entity.getDateCreated());
			EmployeeEntity newRow = employeeRepository.save(entity);
			id = newRow.getId();
		}
		CompanyEmployeeEntity companyEmployeeEntity = new CompanyEmployeeEntity();
		companyEmployeeEntity.setDateCreated(EntityUtils.getCurrentDate());
		companyEmployeeEntity.setDateUpdated(companyEmployeeEntity.getDateCreated());
		companyEmployeeEntity.setCompany_id(companyId);
		companyEmployeeEntity.setEmployee_id(id);
		companyEmployeeRepository.save(companyEmployeeEntity);
		return companyEmployeeEntity.getId();
	}
}
