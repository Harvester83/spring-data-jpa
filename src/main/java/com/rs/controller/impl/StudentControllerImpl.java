package com.rs.controller.impl;

import com.rs.controller.IStudentController;
import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

  @Autowired
  private IStudentService studentService;

  @PostMapping(path = "/save")
  public StudentDto saveStudent(@RequestBody @Valid StudentCreateDto studentDto) {
    return studentService.saveStudent(studentDto);
  }

  @GetMapping(path = "/{id}")
  public StudentDto getStudentById(@PathVariable Integer id) {
    return studentService.getStudentById(id);
  }

  @PutMapping(path = "/update/{sid}")
  @Override
  public StudentDto updateStudent(@PathVariable(name = "sid") Integer sid, @RequestBody StudentCreateDto studentCreateDto) {
    return studentService.updateStudent(sid, studentCreateDto);
  }

  @GetMapping(path = "/list")
  public List<StudentDto> getAll() {
    return studentService.getAll();
  }

  @DeleteMapping(path = "/{sid}")
  public ResponseEntity<Void> deleteStudent(@PathVariable Integer sid) {
    return studentService.deleteStudent(sid);
  }
}
