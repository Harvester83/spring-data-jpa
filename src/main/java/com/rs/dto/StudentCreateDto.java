package com.rs.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateDto {
    private String firstName;
    private String lastName;
    private Date birthOfDay;
}
