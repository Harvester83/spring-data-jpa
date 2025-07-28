package com.rs.dto;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Table(name = "student", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

  @NotEmpty(message = "Please provide firstName")
  @Size(min = 3, max = 11)
  private String firstName;

  @Size(min = 2, max = 10)
  private String lastName;

  public StudentDto(Integer sid, String firstName, String lastName) {
  }
}
