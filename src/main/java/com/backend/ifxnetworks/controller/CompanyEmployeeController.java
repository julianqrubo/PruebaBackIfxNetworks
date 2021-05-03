package com.backend.ifxnetworks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ifxnetworks.model.CompanyEmployeeEntity;
import com.backend.ifxnetworks.service.CompanyEmployeeService;

@RestController
@RequestMapping("/relationCE")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
		RequestMethod.DELETE })
public class CompanyEmployeeController {

	@Autowired
	CompanyEmployeeService companyEmployeeService;
	
	@GetMapping("/getAll")
	public List<CompanyEmployeeEntity> getAll() {
		return companyEmployeeService.getAll();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Long> create(@RequestBody CompanyEmployeeEntity entity) {
		Long id = companyEmployeeService.create(entity);
		return new ResponseEntity<Long>(id, HttpStatus.OK);
	}
}
