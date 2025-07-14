package com.rs.entity;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "student", schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  @Id
  @JsonProperty("sid")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer sid;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("birthOfDay")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private Date birthOfDay;
}
