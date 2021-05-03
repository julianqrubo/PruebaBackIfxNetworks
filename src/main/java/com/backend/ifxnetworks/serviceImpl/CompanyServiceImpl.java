package com.backend.ifxnetworks.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.ifxnetworks.Utils.EntityUtils;
import com.backend.ifxnetworks.model.CompanyEntity;
import com.backend.ifxnetworks.repository.CompanyRepository;
import com.backend.ifxnetworks.service.CompanyService;

@Component
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Override
	public Optional<CompanyEntity> getById(Long id) {
		return companyRepository.findById(id);
	}

	@Override
	public List<CompanyEntity> getAll() {
		return companyRepository.findAll();
	}

	@Override
	public Long create(CompanyEntity entity) {
		entity.setDateCreated(EntityUtils.getCurrentDate());
		entity.setDateUpdated(entity.getDateCreated());
		entity.setName(entity.getName());
		CompanyEntity newRow = companyRepository.save(entity);
		return newRow.getId();
	}

	@Override
	public void update(Long id, CompanyEntity entity) {
		boolean existsById = companyRepository.existsById(id);
		if(existsById) {
			Optional<CompanyEntity> company = companyRepository.findById(id);
			CompanyEntity companyEntity = company.get();
			companyEntity.setDateUpdated(EntityUtils.getCurrentDate());
			companyEntity.setName(entity.getName());
			companyRepository.save(companyEntity);
		}else {
			throw new RuntimeException("No se encontró el registro para actualizar");
		}
	}

	@Override
	public void delete(Long id) {
		companyRepository.deleteById(id);
	}
}
