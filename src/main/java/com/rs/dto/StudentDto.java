package com.rs.dto;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Table(name = "student", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
  private String firstName;
  private String lastName;

  public StudentDto(Integer sid, String firstName, String lastName) {
  }
}
