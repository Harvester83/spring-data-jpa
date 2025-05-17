package com.rs.service.impl;

import com.rs.entity.Student;
import com.rs.repository.StudentRepository;
import com.rs.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public List<Student> getAll() {
    return studentRepository.findAll();
  }
}
