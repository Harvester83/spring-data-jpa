package com.rs.controller.impl;

import com.rs.controller.IStudentController;
import com.rs.entity.Student;
import com.rs.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

  @Autowired
  private IStudentService studentService;

  // Using DTO
  @PostMapping(path = "/save")
  @Override
  public Student saveStudent(@RequestBody Student student) {

    return studentService.saveStudent(student);
  }

  @Override
  public boolean deleteStudent(Student student) {
    return false;
  }

}
