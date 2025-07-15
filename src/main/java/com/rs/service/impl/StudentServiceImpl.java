package com.rs.service.impl;

import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;
import com.rs.repository.StudentRepository;
import com.rs.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

  private final StudentRepository studentRepository;

  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public StudentDto saveStudent(StudentCreateDto studentCreateDto) {

    StudentDto response = new StudentDto();
    Student student = new Student();
    BeanUtils.copyProperties(studentCreateDto, student);

    Student dbStudent = studentRepository.save(student);
    BeanUtils.copyProperties(dbStudent, response);

    return response;
  }

  @Override
  public StudentDto getStudentById(Integer sid) {
    StudentDto studentDto = new StudentDto();

    Optional<Student> optional = studentRepository.findById(sid);

    if (optional.isPresent()) {
      Student dbStudent = optional.get();
      BeanUtils.copyProperties(dbStudent, studentDto);
    }

    return studentDto;
  }

  @Override
  public StudentDto updateStudent(Integer id, StudentCreateDto studentCreateDto) {

    StudentDto studentDto = new StudentDto();
    Optional<Student> optional = studentRepository.findById(id);

    if (optional.isPresent()) {
      Student dbStudent = optional.get();

      dbStudent.setFirstName(studentCreateDto.getFirstName());
      dbStudent.setLastName(studentCreateDto.getLastName());

      Student updateStudent = studentRepository.save(dbStudent);

      BeanUtils.copyProperties(updateStudent, studentDto);

      return studentDto;
    }

    return null;
  }

  public ResponseEntity<Void> deleteStudent(Integer sid) {
    try {
      studentRepository.deleteById(sid);
      return ResponseEntity.noContent().build(); // HTTP 204 без тела
    } catch (EmptyResultDataAccessException ex) {
      return ResponseEntity.notFound().build(); // HTTP 404
    }
  }

  @Override
  public List<StudentDto> getAll() {
    List<StudentDto> dtoList = new ArrayList<>();
    List<Student> studentList = studentRepository.findAll();


    for (Student student : studentList) {
      StudentDto studentDto = new StudentDto();

      BeanUtils.copyProperties(student, studentDto);
      dtoList.add(studentDto);
    }

    return dtoList;

  }
}
