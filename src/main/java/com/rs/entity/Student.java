package com.rs.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "UTC")
  private Date birthOfDay;
}
