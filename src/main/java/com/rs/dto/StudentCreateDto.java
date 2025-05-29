package com.rs.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateDto {
    private String firstName;
    private String lastName;
    private Date birthOfDay;
}
