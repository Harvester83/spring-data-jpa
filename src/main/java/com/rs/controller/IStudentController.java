package com.rs.controller;

import com.rs.entity.Student;

import java.util.List;

public interface IStudentController {

  Student saveStudent(Student student);

  Student getStudentById(Integer student);

  boolean deleteStudent(Integer student);

  List<Student> getAll();
}
