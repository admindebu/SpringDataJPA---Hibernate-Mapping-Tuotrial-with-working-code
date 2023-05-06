package org.techtalk.debu.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techtalk.debu.spring.jpa.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}