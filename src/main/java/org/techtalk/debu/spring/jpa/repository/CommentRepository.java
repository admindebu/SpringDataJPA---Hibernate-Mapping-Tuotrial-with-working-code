package org.techtalk.debu.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techtalk.debu.spring.jpa.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

}