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

import com.backend.ifxnetworks.model.EmployeeEntity;
import com.backend.ifxnetworks.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getById/{id}")
	public Optional<EmployeeEntity> getById(@PathVariable("id") Long id) {
		return employeeService.getById(id);
	}
	
	@GetMapping("/getByDocument/{document}")
	public List<EmployeeEntity> findByDocument(@PathVariable("document") Long document) {
		return employeeService.findByDocument(document);
	}
	
	@GetMapping("/getAll")
	public List<EmployeeEntity> getAll() {
		return employeeService.getAll();
	}
	
//	@PostMapping("/create")
//	public ResponseEntity<Long> create(@RequestBody EmployeeEntity entity) {
//		Long id = employeeService.create(entity);
//		return new ResponseEntity<Long>(id, HttpStatus.OK);
//	}
	
	@PostMapping("/create/{companyId}")
	public ResponseEntity<Long> create(@PathVariable("companyId") Long companyId, @RequestBody EmployeeEntity entity) {
		Long id = employeeService.createRealtionCompanyEmployee(companyId, entity);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody EmployeeEntity entity) {
		employeeService.update(id, entity);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		employeeService.delete(id);
	}
}
