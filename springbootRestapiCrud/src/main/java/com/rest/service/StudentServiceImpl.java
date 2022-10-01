package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.Student;
import com.rest.repo.StudentRepository;
@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	StudentRepository repo;
	@Override
	public void save(Student s) {
		repo.save(s);
		
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> stu=(List<Student>) repo.findAll();
		return stu;
	}

	@Override
	public void removeById(int id) {
		repo.deleteById(id);
		
	}

	@Override
	public Optional<Student> getStudentById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void update(Student s) {
		if(repo.existsById(s.getId())) {
			repo.save(s);
		}
		
	}

}
