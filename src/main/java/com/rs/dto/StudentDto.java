package com.rs.dto;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Table(name = "student", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

  @NotEmpty(message = "Please provide firstName")
  private String firstName;

  private String lastName;

  public StudentDto(Integer sid, String firstName, String lastName) {
  }
}
