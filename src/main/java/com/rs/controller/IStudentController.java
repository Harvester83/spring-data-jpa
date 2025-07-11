package com.rs.controller;

import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;

import java.util.List;

public interface IStudentController {

  StudentDto saveStudent(StudentCreateDto student);

  StudentDto updateStudent(Integer id, StudentCreateDto  student);

  StudentDto getStudentById(Integer student);

  boolean deleteStudent(Integer student);

  List<StudentDto> getAll();
}
