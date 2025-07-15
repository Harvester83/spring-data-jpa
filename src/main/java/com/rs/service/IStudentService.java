package com.rs.service;

import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {
  public StudentDto saveStudent(StudentCreateDto studentCreateDto );

  public StudentDto getStudentById(Integer sid);

  public StudentDto updateStudent(Integer id, StudentCreateDto studentCreateDto);

  public ResponseEntity<Void> deleteStudent(Integer sid);

  public List<StudentDto> getAll();
}
