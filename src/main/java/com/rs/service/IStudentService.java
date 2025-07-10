package com.rs.service;

import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;

import java.util.List;

public interface IStudentService {
  public StudentDto saveStudent(StudentCreateDto studentCreateDto );

  public Student getStudentById(Integer id);

  public Student updateStudent(Integer id, Student student);

  public boolean deleteStudent(Integer id);

  public List<StudentDto> getAll();
}
