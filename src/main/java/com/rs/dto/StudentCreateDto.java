package com.rs.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreateDto {

    @NotEmpty(message = "Please provide firstName")
    @Size(min = 3, max = 11)
    private String firstName;

    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "UTC")
    private Date birthOfDay;
}
