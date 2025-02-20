package com.msvc.students.msvc_students.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.msvc.students.msvc_students.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
List <Student> findAllByCourseId(Long courseId);

//esto basicamente es un query method que va a buscar todos los estudiantes que tengan el Id del curso
}
