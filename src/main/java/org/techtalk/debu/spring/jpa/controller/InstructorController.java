package org.techtalk.debu.spring.jpa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techtalk.debu.spring.jpa.entity.Instructor;
import org.techtalk.debu.spring.jpa.exception.ResourceNotFoundException;
import org.techtalk.debu.spring.jpa.repository.InstructorRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Instructor Controller", tags = { "Instructor Controller" })
public class InstructorController {

	@Autowired
	private InstructorRepository instructorRepository;

	@PostMapping("/api/v1/instructors")
	public Instructor createUser(@Valid @RequestBody Instructor instructor) {
		return instructorRepository.save(instructor);
	}

	@GetMapping("/api/v1/instructors")
	public List<Instructor> getInstructors() {
		return instructorRepository.findAll();
	}

	@GetMapping("/api/v1/instructors/{id}")
	public ResponseEntity<Instructor> getInstructorById(@PathVariable(value = "id") Long instructorId)
			throws ResourceNotFoundException {
		Instructor user = instructorRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/api/v1/instructors/{id}")
	public ResponseEntity<Instructor> updateUser(@PathVariable(value = "id") Long instructorId,
			@Valid @RequestBody Instructor userDetails) throws ResourceNotFoundException {
		Instructor user = instructorRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));
		user.setEmail(userDetails.getEmail());
		final Instructor updatedUser = instructorRepository.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/api/v1/instructors/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long instructorId)
			throws ResourceNotFoundException {
		Instructor instructor = instructorRepository.findById(instructorId)
				.orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + instructorId));

		instructorRepository.delete(instructor);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
