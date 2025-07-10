package com.rs.service.impl;

import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;
import com.rs.repository.StudentRepository;
import com.rs.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

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
  public Student getStudentById(Integer id) {
    Optional<Student> optional = studentRepository.findById(id);
    return optional.orElse(null);
  }

  @Override
  public Student updateStudent(Integer id, Student updateStudent) {
    Student dbStudent = getStudentById(id);

    if (updateStudent != null) {
      dbStudent.setFirstName(updateStudent.getFirstName());
      dbStudent.setLastName(updateStudent.getLastName());
      dbStudent.setBirthOfDay(updateStudent.getBirthOfDay());

      return studentRepository.save(dbStudent);
    }

    return null;
  }

  @Override
  public boolean deleteStudent(Integer id) {
    if (studentRepository.existsById(id)) {
      studentRepository.deleteById(id);
      return true;
    }

    return false;
  }

  @Override
  public List<StudentDto> getAll() {
    List<StudentDto> dtoList = new ArrayList<>();
    List<Student> studentList = studentRepository.findAll();


    for(Student student : studentList) {
      StudentDto studentDto = new StudentDto();

      BeanUtils.copyProperties(student, studentDto);
      dtoList.add(studentDto);
    }

    return dtoList;

  }

}
