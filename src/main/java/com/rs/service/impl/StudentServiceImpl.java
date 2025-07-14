package com.rs.service.impl;

import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;
import com.rs.repository.StudentRepository;
import com.rs.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

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
  public Student updateStudent(Integer id, Student updateStudent) {
//    Student dbStudent = getStudentById(id);

//    if (updateStudent != null) {
//      dbStudent.setFirstName(updateStudent.getFirstName());
//      dbStudent.setLastName(updateStudent.getLastName());
//      dbStudent.setBirthOfDay(updateStudent.getBirthOfDay());
//
//      return studentRepository.save(dbStudent);
//    }

    return null;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteStudent(Integer sid) {
    try {
      studentRepository.deleteById(sid);
      return ResponseEntity.noContent().build(); // HTTP 204

    } catch (EmptyResultDataAccessException ex) {
      return ResponseEntity.notFound().build(); // HTTP 204
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
