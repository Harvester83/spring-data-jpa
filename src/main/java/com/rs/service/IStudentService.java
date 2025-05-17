package com.rs.service;

import com.rs.entity.Student;

import java.util.List;

public interface IStudentService {
  public Student saveStudent(Student student);

  public List<Student> getAll();
}
