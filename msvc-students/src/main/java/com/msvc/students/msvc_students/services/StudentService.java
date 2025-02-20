package com.msvc.students.msvc_students.services;

import java.util.List;
import java.util.Optional;

import com.msvc.students.msvc_students.entities.Student;

public interface StudentService {

List<Student> getAllStudents();

Optional <Student> getStudentById(Long id);

Student createNewStudent(Student student);

void updateStudent(Student student);

void deleteStudentById(Long id);

List <Student> findByCourseId(Long courseId);

}
