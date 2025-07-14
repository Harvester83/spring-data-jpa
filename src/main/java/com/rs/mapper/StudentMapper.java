package com.rs.mapper;

import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;

public class StudentMapper {

  public static StudentDto toDto(Student student) {
    return new StudentDto(
//        student.getId(),
        student.getFirstName(),
        student.getLastName()
    );
  }

  public static Student toEntity(StudentCreateDto dto) {
    Student student = new Student();
    student.setFirstName(dto.getFirstName());
    student.setLastName(dto.getLastName());
    student.setBirthOfDay(dto.getBirthOfDay());
    return student;
  }

  public static void updateEntity(Student student, StudentCreateDto dto) {
    student.setFirstName(dto.getFirstName());
    student.setLastName(dto.getLastName());
    student.setBirthOfDay(dto.getBirthOfDay());
  }
}
