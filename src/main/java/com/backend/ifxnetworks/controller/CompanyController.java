package com.backend.ifxnetworks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ifxnetworks.model.CompanyEntity;
import com.backend.ifxnetworks.service.CompanyService;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@GetMapping("/getById/{id}")
	public Optional<CompanyEntity> getById(@PathVariable("id") Long id) {
		return companyService.getById(id);
	}
	
	@GetMapping("/getAll")
	public List<CompanyEntity> getAll() {
		return companyService.getAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Long> created(@RequestBody CompanyEntity entity){
		Long id = companyService.create(entity);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody CompanyEntity entity) {
		companyService.update(id, entity);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		companyService.delete(id);
	}
}
