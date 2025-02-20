package com.msvc.students.msvc_students.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msvc.students.msvc_students.entities.Student;
import com.msvc.students.msvc_students.services.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("/api/students")
public class StudentsController {
@Autowired
StudentService studentService;

@GetMapping("/getAll")
public List <Student> getAllStudents() {
    return studentService.getAllStudents();
}

@GetMapping("/getById/{id}")
public Optional <Student> getStudentById(@PathVariable Long id) {
    if (id.equals(6L)) {
        throw new IllegalStateException("Estudiante no encontrado!");
    }
    return studentService.getStudentById(id);
}

@PostMapping("/post")
public Student createNewStudent(@RequestBody Student student) {
    return studentService.createNewStudent(student); 
}

@PutMapping("/modify/{id}")
public void updateStudent(@PathVariable Long id, @RequestBody Student student) {
    studentService.updateStudent(student);
}
@DeleteMapping("/delete/{id}")
public void deleteStudentById(@PathVariable Long id){
    studentService.deleteStudentById(id);
}
@GetMapping("/search-by-course/{courseId}")
 ResponseEntity<?> findAllByCourseId(@PathVariable Long courseId){
    return ResponseEntity.ok(studentService.findByCourseId(courseId));
}


}



