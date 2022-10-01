package com.rest.service;

import java.util.List;
import java.util.Optional;

import com.rest.entity.Student;

public interface IStudentService {
	public void save (Student s);
	public List<Student> getAllStudent();
	public void removeById(int id);
	public Optional<Student> getStudentById(int id);
	public void update (Student s);
	

}
