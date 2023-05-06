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
import org.techtalk.debu.spring.jpa.entity.Post;
import org.techtalk.debu.spring.jpa.repository.PostRepository;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "Post Controller", tags = { "Post Controller" })
public class PostController {

	@Autowired
	private PostRepository postRepository;

	@PostMapping(value = "/api/v1/post", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

	public ResponseEntity<Post> savePost(@RequestBody Post post) {

		return new ResponseEntity<Post>(postRepository.save(post), HttpStatus.OK);

	}

	@GetMapping(value = "/api/v1/post/{postId}")
	public ResponseEntity<Optional<Post>> findById(@PathVariable Long postId) {

		return new ResponseEntity<Optional<Post>>(postRepository.findById(postId), HttpStatus.OK);

	}

}
