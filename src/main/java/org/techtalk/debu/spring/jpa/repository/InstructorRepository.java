package org.techtalk.debu.spring.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techtalk.debu.spring.jpa.entity.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}