package com.rs.service;

import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {
  public StudentDto saveStudent(StudentCreateDto studentCreateDto );

  public StudentDto getStudentById(Integer sid);

  public Student updateStudent(Integer id, Student student);

  public ResponseEntity<Void> deleteStudent(Integer id);

  public List<StudentDto> getAll();
}
