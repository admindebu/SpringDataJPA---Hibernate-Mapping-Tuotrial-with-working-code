package org.techtalk.debu.spring.jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techtalk.debu.spring.jpa.entity.Employee;
import org.techtalk.debu.spring.jpa.repository.EmployeeRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Employee Controller", tags = { "Employee Controller" })
public class EmployeeController {

	
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping(value = "/api/v1/employee", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Employee> savePost(@RequestBody Employee employee) {

		return new ResponseEntity<Employee>(employeeRepository.save(employee), HttpStatus.OK);

	}

	@GetMapping(value = "/api/v1/employee/{id}")
	public ResponseEntity<Optional<Employee>> findById(@PathVariable Long id) {

		return new ResponseEntity<Optional<Employee>>(employeeRepository.findById(id), HttpStatus.OK);

	}
}
