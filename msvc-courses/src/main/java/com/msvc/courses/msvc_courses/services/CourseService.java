package com.msvc.courses.msvc_courses.services;

import java.util.List;
import java.util.Optional;

import com.msvc.courses.msvc_courses.entities.Course;
import com.msvc.courses.msvc_courses.httpResponse.StudentsByCourseResponse;

public interface CourseService {
 List <Course> getAllCourses();
 
 Optional <Course> getCourseById(Long id);

 Course  createCourse(Course course);

 void updateCourse(Course course);

 void deleteCourseById(Long id);

 StudentsByCourseResponse findStudentsByIdCourse(Long courseId);



}
