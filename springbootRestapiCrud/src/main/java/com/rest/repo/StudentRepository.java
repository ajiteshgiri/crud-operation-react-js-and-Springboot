package com.rest.repo;

import org.springframework.data.repository.CrudRepository;

import com.rest.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
