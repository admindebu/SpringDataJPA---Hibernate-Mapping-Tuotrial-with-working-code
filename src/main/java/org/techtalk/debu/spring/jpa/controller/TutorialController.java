package org.techtalk.debu.spring.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techtalk.debu.spring.jpa.entity.Tutorial;
import org.techtalk.debu.spring.jpa.service.impl.TutorialServiceImpl;

import io.swagger.annotations.Api;



@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Tutorial Controller", tags = { "Tutorial Controller" })
public class TutorialController {
	
	
	@Autowired
	private TutorialServiceImpl toTutorialServiceImpl;
	
	@PostMapping(value = "/api/v1/tutorial", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public ResponseEntity<Tutorial> saveClient(@RequestBody Tutorial tutorial) {

		return new ResponseEntity<Tutorial>(toTutorialServiceImpl.save(tutorial), HttpStatus.OK);

	}

	@GetMapping(value = "/api/v1/tutorial")
	public ResponseEntity<List<Tutorial>> findAllTutorial() {

		return new ResponseEntity<List<Tutorial>>(toTutorialServiceImpl.findAll(), HttpStatus.OK);

	}
	
	@GetMapping(value = "/api/v1/tutorial/sort")
	public ResponseEntity<List<Tutorial>> findAllTutorialSort() {

		return new ResponseEntity<List<Tutorial>>(toTutorialServiceImpl.findAllSort(), HttpStatus.OK);

	}
	@GetMapping(value = "/api/v1/tutorial/page/{page}/{size}")
	public ResponseEntity<Page<Tutorial>> findAllWithPagination(@PathVariable int page,@PathVariable int size) {

		return new ResponseEntity<Page<Tutorial>>(toTutorialServiceImpl.findAllWithPagination(page,size), HttpStatus.OK);

	}

	@GetMapping(value = "/api/v1/hello")
	public ResponseEntity<String> HelloController() {

		return new ResponseEntity<String>("Hello Controller......Up 9092", HttpStatus.OK);

	}
	
	@GetMapping(value = "/api/v1/tutorial/{title}")
	public ResponseEntity<List<Tutorial>> findByTitleAndSort(@PathVariable String title) {

		return new ResponseEntity<List<Tutorial>>(toTutorialServiceImpl.findByTitleAndSort(title), HttpStatus.OK);

	}
	
	/*	@GetMapping(value = "/api/v1/tutorial/published/{isPublished}")
	public ResponseEntity<List<Tutorial>> findByPublished(@PathVariable String isPublished) {

		return new ResponseEntity<List<Tutorial>>(toTutorialServiceImpl.findByPublished(isPublished), HttpStatus.OK);

	}*/
/*	@GetMapping(value = "/api/v1/tutorial/{title}")
	public ResponseEntity<List<Tutorial>> findByTitleLike(@PathVariable String title) {

		return new ResponseEntity<List<Tutorial>>(toTutorialServiceImpl.findByTitleLike(title), HttpStatus.OK);

	}*/

}
