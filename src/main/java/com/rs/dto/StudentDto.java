package com.rs.dto;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "student", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
  private String firstName;
  private String lastName;
}
