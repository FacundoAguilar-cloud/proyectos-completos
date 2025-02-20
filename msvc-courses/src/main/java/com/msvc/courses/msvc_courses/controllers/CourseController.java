package com.msvc.courses.msvc_courses.controllers;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.courses.msvc_courses.entities.Course;
import com.msvc.courses.msvc_courses.services.CourseService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping("/api/courses")
public class CourseController {
@Autowired
CourseService courseService;

@GetMapping("/getAll")
public List <Course> getAllCourses() {
    return courseService.getAllCourses();
}
@CircuitBreaker(name = "courses" , fallbackMethod = "fallbackSearchCourseById")
@GetMapping("/getById/{id}")
public Optional <Course> getCourseById(@PathVariable Long id) {
    if (id>6) {
        throw new RuntimeException("Error detectado");
    }
    
    return courseService.getCourseById(id);
}
public Optional<Course> fallbackSearchCourseById(Long id, Throwable throwable) {
    // Lógica de fallback
    System.err.println("Error al obtener el estudiante y su courso con id: " + id + ": " + throwable.getMessage());
    return Optional.empty();
}

@PostMapping("/post")
public Course createNewCourse(@RequestBody Course course) {
    return courseService.createCourse(course); 
}

@PutMapping("/modify/{id}")
public void updateCourse(@PathVariable Long id, @RequestBody Course course) {
    courseService.updateCourse(course);
}
@DeleteMapping("/delete/{id}")
public void deleteCourseById(@PathVariable Long id){
    courseService.deleteCourseById(id);
}

@GetMapping("/search-student/{courseId}")
public ResponseEntity<?> findStudentsByIdCourse(@PathVariable Long courseId){
return ResponseEntity.ok(courseService.findStudentsByIdCourse(courseId));
}



}
