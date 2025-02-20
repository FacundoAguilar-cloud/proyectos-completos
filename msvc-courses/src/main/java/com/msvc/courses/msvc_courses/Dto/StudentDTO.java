package com.msvc.courses.msvc_courses.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    private String firstname;
    private String lastname;
    private String email;
    private Long courseId;
}
