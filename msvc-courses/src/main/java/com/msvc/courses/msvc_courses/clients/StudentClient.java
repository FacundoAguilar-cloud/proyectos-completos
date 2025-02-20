package com.msvc.courses.msvc_courses.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.msvc.courses.msvc_courses.Dto.StudentDTO;

@FeignClient(name = "msvc-students", url ="http://localhost:8080/api/students")
public interface StudentClient {
    @GetMapping("/search-by-course/{courseId}")
    List <StudentDTO> findAllStudentsByCourse(@PathVariable Long courseId);
}