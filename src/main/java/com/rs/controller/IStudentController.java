package com.rs.controller;

import com.rs.entity.Student;

public interface IStudentController {

  Student saveStudent(Student student);

  boolean deleteStudent(Student student);
}
