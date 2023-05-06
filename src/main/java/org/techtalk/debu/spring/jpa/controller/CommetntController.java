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
import org.techtalk.debu.spring.jpa.entity.Comment;
import org.techtalk.debu.spring.jpa.repository.CommentRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Comment Controller", tags = { "Comment Controller" })
public class CommetntController {

	@Autowired
	private CommentRepository commentRepository;

	@PostMapping(value = "/api/v1/comment", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {

		return new ResponseEntity<Comment>(commentRepository.save(comment), HttpStatus.OK);

	}

	@GetMapping(value = "/api/v1/comment/{commentId}")
	public ResponseEntity<Optional<Comment>> findById(@PathVariable Long commentId) {

		return new ResponseEntity<Optional<Comment>>(commentRepository.findById(commentId), HttpStatus.OK);

	}

}
