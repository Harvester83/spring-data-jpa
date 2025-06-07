package com.rs.controller.impl;

import com.rs.controller.IStudentController;
import com.rs.dto.StudentCreateDto;
import com.rs.dto.StudentDto;
import com.rs.entity.Student;
import com.rs.mapper.StudentMapper;
import com.rs.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/api/student")
public class StudentControllerImpl implements IStudentController {

  @Autowired
  private IStudentService studentService;

  @PostMapping(path = "/save")
  public StudentDto saveStudent(@RequestBody StudentCreateDto studentDto) {
    Student saved = studentService.saveStudent(StudentMapper.toEntity(studentDto));
    return StudentMapper.toDto(saved);
  }

    @GetMapping(path = "/{id}")
    public StudentDto getStudentById(@PathVariable Integer id) {
      return StudentMapper.toDto(studentService.getStudentById(id));
    }

  @PutMapping(path = "/{id}")
  public StudentDto updateStudent(@PathVariable Integer id, @RequestBody StudentCreateDto dto) {
    Student updated = studentService.updateStudent(id, StudentMapper.toEntity(dto));
    return StudentMapper.toDto(updated);
  }

  @GetMapping(path = "/list")
  public List<StudentDto> getAll() {
    return studentService.getAll()
        .stream()
        .map(StudentMapper::toDto)
        .collect(Collectors.toList());
  }

  @DeleteMapping(path = "/{id}")
  public boolean deleteStudent(@PathVariable Integer id) {
    return studentService.deleteStudent(id);
  }
}
