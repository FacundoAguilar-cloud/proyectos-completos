package com.msvc.courses.msvc_courses.httpResponse;


import java.util.List;

import com.msvc.courses.msvc_courses.Dto.StudentDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StudentsByCourseResponse {
 private String courseName;
 private String teacher;
 private List <StudentDTO> studentDTOList;   
}
