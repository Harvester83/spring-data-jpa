package com.rs.controller;

import com.rs.entity.Student;

import java.util.List;

public interface IStudentController {

  Student saveStudent(Student student);

  List<Student> getAll();

  boolean deleteStudent(Student student);
}
