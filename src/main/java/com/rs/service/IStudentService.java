package com.rs.service;

import com.rs.entity.Student;

import java.util.List;

public interface IStudentService {
  public Student saveStudent(Student student);

  public Student getStudentById(Integer id);

  public Student updateStudent(Integer id, Student student);

  public boolean deleteStudent(Integer id);

  public List<Student> getAll();
}
