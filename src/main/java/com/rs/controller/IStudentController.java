package com.rs.controller;

import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentController {

  StudentDto saveStudent(StudentCreateDto student);

  StudentDto updateStudent(Integer id, StudentCreateDto studentCreateDto);

  StudentDto getStudentById(Integer sid);

  ResponseEntity<Void> deleteStudent(Integer student);

  List<StudentDto> getAll();
}
