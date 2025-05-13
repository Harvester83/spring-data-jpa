package com.rs.service.impl;

import com.rs.entity.Student;
import com.rs.repository.StudentRepository;
import com.rs.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

  @Autowired
  private StudentRepository studentRepository;

   /* Альтернативы @Autowired
    Сейчас рекомендуется использовать внедрение через конструктор
    (это более читаемо и проще для тестирования):*/
    //  public StudentServiceImpl(StudentRepository studentRepository) {
    //    this.studentRepository = studentRepository;
    //  }

  @Override
  public Student saveStudent(Student student) {
    return studentRepository.save(student);
  }
}
